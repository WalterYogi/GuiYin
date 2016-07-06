package com.finance.brid.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.finance.brid.Api;
import com.finance.brid.Constant;
import com.finance.brid.R;
import com.finance.brid.activity.LoginActivity;
import com.finance.brid.activity.ResumeActivity;
import com.finance.brid.activity.SettingActivity;
import com.finance.brid.entity.UploadFaceReturnObject;
import com.finance.brid.presenter.PostStringPresenter;
import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.utils.AppUtils;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.ui.utils.SPUtils;
import com.finance.brid.ui.utils.StringUtils;
import com.finance.brid.ui.utils.Utils;
import com.finance.brid.view.IStringView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wu.utils.CircleImageView;
import com.wu.utils.PopWindow;
import com.wu.utils.okhttp.OkHttpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by admin on 2016/6/22.
 */
public class Fragment4 extends BaseFragment implements View.OnClickListener {
    private LinearLayout userInfo;
    private LinearLayout linearUser;
    private CircleImageView imgUserFace;
    private TextView tvUserName;
    private LinearLayout linearResume;
    private TextView tvResume;
    private LinearLayout linearSetting;
    private TextView tvSetting;
    private LinearLayout linearUserFeedback;
    private TextView tvUserFeedback;
    private LinearLayout linearComment;
    private TextView tvComment;


    private PopWindow popWindow;
    private static final String PHOTO_FILE_NAME = "user_face.jpg";
    public final static int PHOTO_REQUEST_CUT = 100;
    public final static int PHOTO_REQUEST_GALLERY = 101;
    public final static int PHOTO_REQUEST_CAMERA = 102;

    private PostStringPresenter presenter;
    private File file;
    private Bitmap bitmap;
    private ImageLoader imageLoader;
    private UploadFaceReturnObject uploadFaceReturnObject;
    private long fileId;
    private String path;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContainerView(R.layout.fragment_4);
        presenter = new PostStringPresenter(mContext, iStringView);
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        userInfo = (LinearLayout) view.findViewById(R.id.user_info);
        linearUser = (LinearLayout) view.findViewById(R.id.linear_user);
        imgUserFace = (CircleImageView) view.findViewById(R.id.img_user_face);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        linearResume = (LinearLayout) view.findViewById(R.id.linear_resume);
        linearComment = (LinearLayout) view.findViewById(R.id.linear_comment);
        tvComment = (TextView) view.findViewById(R.id.tv_comment);
        tvResume = (TextView) view.findViewById(R.id.tv_resume);
        linearSetting = (LinearLayout) view.findViewById(R.id.linear_setting);
        tvSetting = (TextView) view.findViewById(R.id.tv_setting);
        linearUserFeedback = (LinearLayout) view.findViewById(R.id.linear_user_feedback);
        tvUserFeedback = (TextView) view.findViewById(R.id.tv_user_feedback);
        linearUser.setOnClickListener(this);
        imgUserFace.setOnClickListener(this);
        linearResume.setOnClickListener(this);
        linearComment.setOnClickListener(this);
        linearSetting.setOnClickListener(this);
        linearUserFeedback.setOnClickListener(this);
        path = SPUtils.getString(mContext, "path");
        if(!StringUtils.isBlank(path)) {
            LogUtils.i(SPUtils.getString(mContext, "path"));
            imageLoader.displayImage(path, imgUserFace, Utils.getOptions(), null);
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.img_user_face:
                popWindow = new PopWindow(mActivity, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == R.id.btn_photo) {
                            photo();
                            popWindow.dismiss();
                        } else if (v.getId() == R.id.btn_gallery) {
                            gallery();
                            popWindow.dismiss();
                        }
                    }
                });
                //显示窗口
                popWindow.showAtLocation(mActivity.findViewById(R.id.user_info), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
                break;
            case R.id.linear_user:
//                intent = new Intent(mActivity, UserInfoActivity.class);
                break;
            case R.id.linear_resume:
                intent = new Intent(mActivity, ResumeActivity.class);
                break;
            case R.id.linear_comment:
                intent = new Intent(mActivity, LoginActivity.class);
                break;
            case R.id.linear_setting:
                intent = new Intent(mActivity, SettingActivity.class);
                break;
        }
        if (intent != null) {
            intent.putExtra(Constant.BUNDLE, bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_REQUEST_CAMERA) {
            Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME));
            crop(uri);
        } else if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (data != null) {
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == PHOTO_REQUEST_CUT) {
            if (data != null && data.getParcelableExtra("data") != null) {
                bitmap = data.getParcelableExtra("data");
                file = saveBitmap(bitmap, "userFace");
                presenter.getData();
            }

        }
    }

    /*
     * 从相册获取
	 */
    private void gallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    /*
     * 拍照获取
     */
    private void photo() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment
                        .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    /**
     * 剪切图片
     *
     * @param uri
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }
    private File saveBitmap(Bitmap bitmap,String bitName)
    {
        File file = new File("/sdcard/DCIM/Camera/"+bitName);
        if(file.exists()){
            file.delete();
        }
        FileOutputStream out;
        try{
            out = new FileOutputStream(file);
            if(bitmap.compress(Bitmap.CompressFormat.PNG, 90, out))
            {
                out.flush();
                out.close();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 更换图片
     */
    private IStringView iStringView = new IStringView() {
        @Override
        public RequestUrl getRequestUrl() {
            RequestUrl requestUrl = mActivity.bindUrl(Api.UPLOAD, AppUtils.getCurrentClassName(), false);
            requestUrl.params.put("file", file);
            return requestUrl;
        }

        @Override
        public void onResponse(String response) {
            uploadFaceReturnObject = mActivity.gson.fromJson(response, UploadFaceReturnObject.class);
            fileId = uploadFaceReturnObject.getFile_id();
            path = uploadFaceReturnObject.getPath();
            SPUtils.putLong(mContext, "file_id", fileId);
            SPUtils.putString(mContext, "path", path);
            imgUserFace.setImageBitmap(bitmap);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(AppUtils.getCurrentClassName());
    }
}

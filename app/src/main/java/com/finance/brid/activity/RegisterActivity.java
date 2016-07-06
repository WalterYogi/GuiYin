package com.finance.brid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.finance.brid.R;
import com.finance.brid.presenter.GetStringPresenter;
import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.utils.AppUtils;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.ui.utils.StringUtils;
import com.finance.brid.view.IStringView;
import com.wu.utils.okhttp.OkHttpUtils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2016/5/27.
 * 注册界面
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText etPhone;
    private EditText etCode;
    private TextView tvCode;
    private EditText etPassWord;
    private EditText etRepeatPassWord;
    private Button btnRegister;
    private TextView tvLogin;

    private int timeLength = 120;
    private Timer timer;

    private GetStringPresenter presenter;

    public static final String PHONE_PATTERN = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\\\d{8}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);
        setToolBarMode(BACK, "注册");
        presenter = new GetStringPresenter(mContext, iStringView);
//        codePresenter = new PostPresenter(mContext, codeCObjectView);
        initView();
    }

    private void initView() {
        etPhone = (EditText) findViewById(R.id.et_phone);
        tvCode = (TextView) findViewById(R.id.tv_code);
        etCode = (EditText) findViewById(R.id.et_code);
        etPassWord = (EditText) findViewById(R.id.et_pass_word);
        etRepeatPassWord = (EditText) findViewById(R.id.et_repeat_pass_word);
        btnRegister = (Button) findViewById(R.id.btn_register);
        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvCode.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        if (id == R.id.tv_code) {
            String phone = etPhone.getText().toString().trim();
            if(StringUtils.isBlank(phone)) {
                longToast("请输入手机号");
            } else {
                if(isMobileNO(phone)) {
                    tvCode.setClickable(false);
                    timer = new Timer();
                    timer.schedule(timerTask, 1000, 1000);
                } else {
                    longToast("请输入正确的手机号");
                }
            }

        } else if (id == R.id.btn_register) {
            presenter.getData();
        } else if (id == R.id.tv_login) {
//            intent = new Intent(this, LoginActivity.class);
            finish();
        }

        if(intent != null){
            startActivity(intent);
        }
    }

    /**
     * 注册请求
     */
    public IStringView iStringView = new IStringView() {

        @Override
        public RequestUrl getRequestUrl() {
            RequestUrl requestUrl = bindUrl("http://www.baidu.com", AppUtils.getCurrentClassName(), false);
            return requestUrl;
        }

        @Override
        public void onResponse(String response) {
            LogUtils.i(response);
        }

    };
//    /**
//     * 获取验证码
//     */
//    public IStringView codeCObjectView = new IStringView() {
//        @Override
//        public void setObject(String response) {
//        }
//
//        @Override
//        public RequestUrl getRequestUrl() {
//            RequestUrl requestUrl = bindUrl(Api.LOGIN, false);
//            HashMap<String, String> params = requestUrl.getParams();
//            return requestUrl;
//        }
//
//        @Override
//        public boolean handlerRequest(Response response) {
//            return handlerRequest(response);
//        }
//
//
//        @Override
//        public void onSuccess() {
//            timer = new Timer();
//            timer.schedule(timerTask, 1000, 1000);
//        }
//
//        @Override
//        public void onFailed() {
//            longToast("发送失败");
//            tvCode.setClickable(true);
//        }
//    };
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            timeLength--;
            tvCode.setText(String.valueOf(timeLength) + "s");
            if (timeLength <= 0) {
                tvCode.setText("获取验证码");
                timeLength = 120;
                tvCode.setClickable(true);
                timer.cancel();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(AppUtils.getCurrentClassName());
    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,//D])|(18[0,5-9]))//d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }

}

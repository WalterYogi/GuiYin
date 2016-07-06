package com.finance.brid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.finance.brid.Api;
import com.finance.brid.R;
import com.finance.brid.presenter.PostStringPresenter;
import com.finance.brid.ui.http.RequestUrl;
import com.finance.brid.ui.utils.AppUtils;
import com.finance.brid.ui.utils.LogUtils;
import com.finance.brid.ui.utils.StringUtils;
import com.finance.brid.view.IStringView;
import com.wu.utils.okhttp.OkHttpUtils;
import com.wu.utils.okhttp.model.HttpParams;

/**
 * Created by admin on 2016/5/27.
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPassWord;
    private Button btnLogin;
    private TextView tvForgetPW;
    private TextView tvRegister;

    private PostStringPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        setToolBarMode(BACK, "登录");
        presenter = new PostStringPresenter(mActivity, iStringView);
        LogUtils.i(AppUtils.getCurrentClassName());
        initView();
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        etPassWord = (EditText) findViewById(R.id.et_pass_word);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvForgetPW = (TextView) findViewById(R.id.tv_forget_pw);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        btnLogin.setOnClickListener(this);
        tvForgetPW.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        if (id == R.id.btn_login) {
            String name = etName.getText().toString().trim();
            String pw = etPassWord.getText().toString().trim();
            if (StringUtils.isBlank(name) && StringUtils.isBlank(pw)) {
                longToast("请输入用户名和密码");
            } else if (StringUtils.isBlank(name)) {
                longToast("请输入用户名");
            } else if (StringUtils.isBlank(pw)) {
                longToast("请输入密码");
            } else {
               presenter.getData();
            }
        } else if (id == R.id.tv_forget_pw) {
            intent = new Intent(this, RegisterActivity.class);
        } else if (id == R.id.tv_register) {
            intent = new Intent(this, RegisterActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }

    }

    public IStringView iStringView = new IStringView() {

        @Override
        public RequestUrl getRequestUrl() {
            RequestUrl requestUrl = bindUrl(Api.LOGIN, AppUtils.getCurrentClassName(), false);
            HttpParams params = requestUrl.getParams();
            params.put("ac", etName.getText().toString().toString());
            params.put("pwd", etPassWord.getText().toString().toString());
            return requestUrl;
        }

        @Override
        public void onResponse(String response) {
            longToast(response);
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(AppUtils.getCurrentClassName());
    }
}

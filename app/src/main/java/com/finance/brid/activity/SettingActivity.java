package com.finance.brid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.finance.brid.R;

/**
 * Created by admin on 2016/6/23.
 */
public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_layout);
        setToolBarMode(BACK, "设置");
    }
}

package com.finance.brid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.finance.brid.R;

/**
 * Created by admin on 2016/7/4.
 */
public class ResumePreViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_preview_layout);
        setToolBarMode(BACK, "简历预览");
    }
}

package com.finance.brid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.finance.brid.R;

/**
 * Created by admin on 2016/7/4.
 */
public class ResumeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_layout);
        setToolBarMode(BACK, "简历");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_resume_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.user_resumw){
            Intent intent = new Intent(this, ResumePreViewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

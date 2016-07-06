package com.finance.brid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.finance.brid.Constant;
import com.finance.brid.R;


/**
 * Created by admin on 2016/6/23.
 */
public class EditActivity extends BaseActivity {
    private EditText etEdit;

    private String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_layout);
        setToolBarMode(BACK, "编辑");
        initIntent();
        assignViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_info_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.user_save){
            longToast("保存");
            Intent intent = new Intent();
            intent.putExtra(Constant.CONTENT, etEdit.getText().toString().trim());
            setResult(1, intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initIntent() {
        Bundle bundle = getIntent().getBundleExtra(Constant.BUNDLE);
        content = bundle.getString(Constant.CONTENT);
    }

    private void assignViews() {
        etEdit = (EditText) findViewById(R.id.et_edit);
        etEdit.setText(content);
        etEdit.setSelection(content.length());
    }

}

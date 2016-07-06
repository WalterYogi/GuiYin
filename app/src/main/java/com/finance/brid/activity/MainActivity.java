package com.finance.brid.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.finance.brid.R;
import com.finance.brid.fragment.Fragment1;
import com.finance.brid.fragment.Fragment2;
import com.finance.brid.fragment.Fragment3;
import com.finance.brid.fragment.Fragment4;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private LinearLayout linearFragment1;
    private ImageView imgFragment1;
    private TextView tvFragment1;
    private LinearLayout linearFragment2;
    private ImageView imgFragment2;
    private TextView tvFragment2;
    private LinearLayout linearFragment3;
    private ImageView imgFragment3;
    private TextView tvFragment3;
    private LinearLayout linearFragment4;
    private ImageView imgFragment4;
    private TextView tvFragment4;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private boolean mIsExit;
    private Timer mExitTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        mExitTimer = new Timer();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        setTabSelection(1);
    }

    /**
     * 初始化控件
     */
    private void assignViews() {
        linearFragment1 = (LinearLayout) findViewById(R.id.linear_fragment1);
        imgFragment1 = (ImageView) findViewById(R.id.img_fragment1);
        tvFragment1 = (TextView) findViewById(R.id.tv_fragment1);
        linearFragment2 = (LinearLayout) findViewById(R.id.linear_fragment2);
        imgFragment2 = (ImageView) findViewById(R.id.img_fragment2);
        tvFragment2 = (TextView) findViewById(R.id.tv_fragment2);
        linearFragment3 = (LinearLayout) findViewById(R.id.linear_fragment3);
        imgFragment3 = (ImageView) findViewById(R.id.img_fragment3);
        tvFragment3 = (TextView) findViewById(R.id.tv_fragment3);
        linearFragment4 = (LinearLayout) findViewById(R.id.linear_fragment4);
        imgFragment4 = (ImageView) findViewById(R.id.img_fragment4);
        tvFragment4 = (TextView) findViewById(R.id.tv_fragment4);
        linearFragment1.setOnClickListener(this);
        linearFragment2.setOnClickListener(this);
        linearFragment3.setOnClickListener(this);
        linearFragment4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_fragment1:
                setTabSelection(1);
                break;
            case R.id.linear_fragment2:
                setTabSelection(2);
                break;
            case R.id.linear_fragment3:
                setTabSelection(3);
                break;
            case R.id.linear_fragment4:
                setTabSelection(4);
                break;
            default:
                break;
        }
    }

    /**
     * 选择页面
     * @param selectionId
     */
    private void setTabSelection(int selectionId){
        clearSelection();
        transaction = fragmentManager.beginTransaction();
        hideFragmentAll(transaction);
        switch(selectionId){
            case 1:
//                setToolBarTitle(R.string.main_1);
                imgFragment1.setImageResource(R.drawable.main_pressed_1);
                tvFragment1.setTextColor(getResources().getColor(R.color.app_main_bottom_pressed));
                if(fragment1 == null){
                    fragment1 = new Fragment1();
                    transaction.add(R.id.main_content, fragment1);
                }else{
                    transaction.show(fragment1);
                }
                break;
            case 2:
//                setToolBarTitle(R.string.main_2);
                imgFragment2.setImageResource(R.drawable.main_pressed_2);
                tvFragment2.setTextColor(getResources().getColor(R.color.app_main_bottom_pressed));
                if(fragment2 == null){
                    fragment2 = new Fragment2();
                    transaction.add(R.id.main_content, fragment2);
                }else{
                    transaction.show(fragment2);
                }
                break;
            case 3:
//                setToolBarTitle(R.string.main_3);
                imgFragment3.setImageResource(R.drawable.main_pressed_3);
                tvFragment3.setTextColor(getResources().getColor(R.color.app_main_bottom_pressed));
                if(fragment3 == null){
                    fragment3 = new Fragment3();
                    transaction.add(R.id.main_content, fragment3);
                }else{
                    transaction.show(fragment3);
                }
                break;
            case 4:
//                setToolBarTitle(R.string.main_4);
                imgFragment4.setImageResource(R.drawable.main_pressed_4);
                tvFragment4.setTextColor(getResources().getColor(R.color.app_main_bottom_pressed));
                if(fragment4 == null){
                    fragment4 = new Fragment4();
                    transaction.add(R.id.main_content, fragment4);
                }else{
                    transaction.show(fragment4);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
     */
    private void hideFragmentAll(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
        if (fragment4 != null) {
            transaction.hide(fragment4);
        }
    }

    /**
     * 清除所有选项
     */
    private void clearSelection() {
        imgFragment1.setImageResource(R.drawable.main_normal_1);
        imgFragment2.setImageResource(R.drawable.main_normal_2);
        imgFragment3.setImageResource(R.drawable.main_normal_3);
        imgFragment4.setImageResource(R.drawable.main_normal_4);
        tvFragment1.setTextColor(getResources().getColor(R.color.app_main_bottom_normal));
        tvFragment2.setTextColor(getResources().getColor(R.color.app_main_bottom_normal));
        tvFragment3.setTextColor(getResources().getColor(R.color.app_main_bottom_normal));
        tvFragment4.setTextColor(getResources().getColor(R.color.app_main_bottom_normal));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //returnHome();
            synchronized (mContext) {
                if (mIsExit) {
                    mIsExit = false;
                    finish();
                }
                longToast("再按一次退出应用");
                mIsExit = true;
                mExitTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExitTimer.cancel();
        mExitTimer = null;
    }
}

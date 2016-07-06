package com.finance.brid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.brid.App;
import com.finance.brid.activity.BaseActivity;


/**
 * Created by admin on 2016/6/22.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    protected Context mContext;
    public App mApp;
    protected View mContainerView;
    protected int mViewId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
        mContext = context;
        mApp = mActivity.mApp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mContainerView == null){
            mContainerView = inflater.inflate(mViewId, null);
            initView(mContainerView);
        }
        ViewGroup parent = (ViewGroup) container.getParent();
        if(parent != null){
            parent.removeView(mContainerView);
        }
        return mContainerView;
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        mActivity.setTitle(title);
    }

    protected void setContainerView(int viewId) {
        mViewId = viewId;
    }

    protected void initView(View view){}

}

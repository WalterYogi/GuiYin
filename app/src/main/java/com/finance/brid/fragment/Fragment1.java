package com.finance.brid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.finance.brid.R;
import com.wu.utils.switchbutton.SwitchButton;

/**
 * Created by admin on 2016/6/22.
 */
public class Fragment1 extends BaseFragment {
    private Toolbar toolbar;
    private TextView tvSearch;
    private SwitchButton switchButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContainerView(R.layout.fragment_1);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        tvSearch = (TextView) view.findViewById(R.id.tv_search);
        toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
        tvSearch.setVisibility(View.VISIBLE);
        switchButton = (SwitchButton) view.findViewById(R.id.switch_button);
        mActivity.longToast(String.valueOf(switchButton.isEnabled()));

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mActivity.longToast(String.valueOf(isChecked));
//                if(!isChecked) {
//                    switchButton.setEnabled(true);
//                } else {
//                    switchButton.setEnabled(false);
//                }
            }
        });
        switchButton.setCheckedImmediatelyNoEvent(false);

    }
}

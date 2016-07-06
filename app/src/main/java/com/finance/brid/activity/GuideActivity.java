package com.finance.brid.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.finance.brid.R;
import com.finance.brid.ui.views.IndicatorView;


/**
 * Created by admin on 2016/5/17.
 */
public class GuideActivity extends BaseActivity {

    private ViewPager mViewPager;
    private IndicatorView mIndicatorView;

    private ViewPagerAdapter adapter;
    private int imgs[] = new int[]{R.drawable.guide1, R.drawable.guide2, R.drawable.guide3, R.drawable.guide4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_layout);
        init();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIndicatorView = (IndicatorView) findViewById(R.id.dots_indicator);
        adapter = new ViewPagerAdapter(this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mIndicatorView.setViewPager(mViewPager);
    }

    /**
     * 获取图片
     * @return
     */
    public int[] getImages(){
        return null;
    }

    class ViewPagerAdapter extends PagerAdapter {
        private Context context;

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.guide_item, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_item);
            TextView btnEnter = (TextView) view.findViewById(R.id.btn_enter);
            imageView.setImageResource(imgs[position]);
            if(position== imgs.length-1){
                btnEnter.setVisibility(View.VISIBLE);
            } else {
                btnEnter.setVisibility(View.GONE);
            }
            btnEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(context, MainActivity.class));
                    GuideActivity.this.finish();
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
    class ChangedListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mViewPager.setCurrentItem(position);
            mViewPager.invalidate();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}

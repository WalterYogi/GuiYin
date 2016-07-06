package com.finance.brid.ui.utils;

import android.graphics.Bitmap;

import com.finance.brid.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by admin on 2016/7/1.
 */
public class Utils {

    /**
     * 设置universal-image-loader的参数
     *
     * @return
     */
    public static DisplayImageOptions getOptions(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.icon_right) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.icon_right) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.icon_right) // 设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
                .delayBeforeLoading(100)  // 下载前的延迟时间
                .cacheInMemory(false) // default  设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // default  设置下载的图片是否缓存在SD卡中
                .displayer(new FadeInBitmapDisplayer(100))// 图片加载好后渐入的动画时间
//                .preProcessor(...)
//        .postProcessor(...)
//        .extraForDownloader(...)
//        .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565) // 设置为RGB565比起默认的ARGB_8888要节省大量的内存
//                .decodingOptions(...)  // 图片的解码设置
//        .displayer(new SimpleBitmapDisplayer()) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
                .build();
        return options;
    }
}

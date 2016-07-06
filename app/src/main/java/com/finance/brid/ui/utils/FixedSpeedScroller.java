package com.finance.brid.ui.utils;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * 
 * Created by wmi01 on 2015年11月4日.
 * 
 * TODO 控制viewpager的滑动速度
 */
public class FixedSpeedScroller extends Scroller {      
	private int mDuration = 200;      
	public FixedSpeedScroller(Context context) {         
		super(context);     
		}      
	public FixedSpeedScroller(Context context, Interpolator interpolator) {         
		super(context, interpolator);     
		}      
	     
	@Override    
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {    
		// Ignore received duration, use fixed one instead         
		super.startScroll(startX, startY, dx, dy, mDuration);     
		}      
	@Override     
	public void startScroll(int startX, int startY, int dx, int dy) {        
			// Ignore received duration, use fixed one instead        
			super.startScroll(startX, startY, dx, dy, mDuration);    
			} 
	public void setmDuration(int time){
		mDuration = time;
	}	
	public int getmDuration(){
		return mDuration;
	}	

}

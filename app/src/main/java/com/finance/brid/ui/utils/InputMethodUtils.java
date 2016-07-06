package com.finance.brid.ui.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 
 * Created by wmi01 on 2015年11月4日.
 * 
 * TODO 键盘相关工具类
 */
public class InputMethodUtils {

	/**
	 * 如果输入法在窗口上已经显示，则隐藏，反之则显示
	 * @param context
	 */
	public static void toggleInputMethod(Context context){
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);  
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);  
	}
	/**
	 * 强制显示软键
	 * @param context
	 * @param view
	 */
	public static void forceShowInputMethod(Context context,View view){
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);  
		imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);    
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
	}
	/**
	 * 强制隐藏软键
	 * @param context
	 * @param view
	 */
	public static void forceHideInputMethod(Context context,View view){
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);  
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘   
	}
	/**
	 * 得到键盘显示状态
	 * @param context
	 */
	public static boolean getInputMethodState(Context context){
		InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);  
		boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法显示 
		return isOpen;
	}
}

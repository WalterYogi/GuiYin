package com.finance.brid.ui.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * Created by wmi01 on 2015年11月4日.
 * 
 * TODO 跟App相关的辅助类 
 */
public class AppUtils {
	 /** 
     * 获取应用程序名称 
     */  
    public static String getAppName(Context context)  
    {  
        try  
        {  
            PackageManager packageManager = context.getPackageManager();  
            PackageInfo packageInfo = packageManager.getPackageInfo(  
                    context.getPackageName(), 0);  
            int labelRes = packageInfo.applicationInfo.labelRes;  
            return context.getResources().getString(labelRes);  
        } catch (NameNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     * 获得系统apk的版本名称 
     *  
     * @param context 
     * @return 当前应用的版本名称 
     */  
    public static String getVersionName(Context context)  
    {  
        try  
        {  
            PackageManager packageManager = context.getPackageManager();  
            PackageInfo packageInfo = packageManager.getPackageInfo(  
                    context.getPackageName(), 0);  
            return packageInfo.versionName;  
  
        } catch (NameNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    /**
	 * 获得系统apk的版本号
	 * 
	 * @param context
	 * @return
	 */
	public static int getVerCode(Context context) {
		int verCode = -1;
		try {
			verCode = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return verCode;
	}
	
	/**
	 * 获取包名
	 */
	public static String getPackageName(Context context){
		return context.getPackageName();
	}

    /**
     * 获取类名
     * @return
     */
    public static String getCurrentClassName() {
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        String className = stacks[level].getClassName();
        return className;
    }
}

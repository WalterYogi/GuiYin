package com.finance.brid.ui.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmi01 on 2015年11月4日.
 * 
 * TODO SD卡相关的辅助类
 */
public class SDCardUtils {
	
	/**
	 * 设置应用存储缓存、下载内容等路径
	 */
	public static File getOwnCacheDirectory(Context context, String second){
		 String first =  AppUtils.getPackageName(context);
		File appCacheDir = null;
			if(isFirstSdcardMounted()){
				appCacheDir = new File(Environment.getExternalStorageDirectory(), first);
				if(!appCacheDir.exists()){
					appCacheDir.mkdir();
				}
				appCacheDir = new File(appCacheDir, second);
				if(!appCacheDir.exists()){
					appCacheDir.mkdir();
				}
			} else {
				appCacheDir = context.getCacheDir();
				if(!appCacheDir.exists()){
					appCacheDir.mkdir();
				}
				appCacheDir = new File(appCacheDir, second);
				if(!appCacheDir.exists()){
					appCacheDir.mkdir();
				}
			}
		return appCacheDir;
	}

	/**
	 * 判断内置sd卡是否存在
	 */
	public static boolean isFirstSdcardMounted() {
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断外置sd卡是否存在
	 */
	public static boolean isSecondSDcardMounted() {  
        String sd2 = getSecondExterPath();  
        if (sd2 == null) {  
            return false;  
        }  
        return checkFsWritable(sd2 + File.separator);  
  
    }  
  
    // 测试外置sd卡是否卸载，不能直接判断外置sd卡是否为null，因为当外置sd卡拔出时，仍然能得到外置sd卡路径。我这种方法是按照android谷歌测试DICM的方法，  
    // 创建一个文件，然后立即删除，看是否卸载外置sd卡  
    // 注意这里有一个小bug，即使外置sd卡没有卸载，但是存储空间不够大，或者文件数已至最大数，此时，也不能创建新文件。此时，统一提示用户清理sd卡吧  
    private static boolean checkFsWritable(String dir) {  
  
        if (dir == null)  
            return false;  
  
        File directory = new File(dir);  
  
        if (!directory.isDirectory()) {  
            if (!directory.mkdirs()) {  
                return false;  
            }  
        }  
  
        File f = new File(directory, ".keysharetestgzc");  
        try {  
            if (f.exists()) {  
                f.delete();  
            }  
            if (!f.createNewFile()) {  
                return false;  
            }  
            f.delete();  
            return true;  
  
        } catch (Exception e) {  
        }  
        return false;  
  
    } 
	/**
	 * 得到内置sd卡的路径
	 */
	public static String getFirstExterPath() {
		return Environment.getExternalStorageDirectory().getPath();
	}
	/**
	 * 得到外置sd卡的路径
	 * 返回值不带File seperater "/",如果没有外置第二个sd卡,返回null 
	 */
    public static String getSecondExterPath() {  
        List<String> paths = getAllExterSdcardPath();  
  
        if (paths.size() == 2) {  
  
            for (String path : paths) {  
                if (path != null && !path.equals(getFirstExterPath())) {  
                    return path;  
                }  
            }  
  
            return null;  
  
        } else {  
            return null;  
        }  
    } 

	/**
	 * 得到全部存储的路径
	 */
	public static List<String> getAllExterSdcardPath() {
		List<String> SdList = new ArrayList<String>();

		String firstPath = getFirstExterPath();

		// 得到路径
		try {
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("mount");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			String line;
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				// 将常见的linux分区过滤掉
				if (line.contains("secure"))
					continue;
				if (line.contains("asec"))
					continue;
				if (line.contains("media"))
					continue;
				if (line.contains("system") || line.contains("cache")
						|| line.contains("sys") || line.contains("data")
						|| line.contains("tmpfs") || line.contains("shell")
						|| line.contains("root") || line.contains("acct")
						|| line.contains("proc") || line.contains("misc")
						|| line.contains("obb")) {
					continue;
				}

				if (line.contains("fat") || line.contains("fuse")
						|| (line.contains("ntfs"))) {

					String columns[] = line.split(" ");
					if (columns != null && columns.length > 1) {
						String path = columns[1];
						if (path != null && !SdList.contains(path)
								&& path.contains("sd"))
							SdList.add(columns[1]);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!SdList.contains(firstPath)) {
			SdList.add(firstPath);
		}

		return SdList;
	}

	/**
	 * 获取系统存储路径
	 */
	public static String getRootDirectoryPath() {
		return Environment.getRootDirectory().getAbsolutePath();
	}
	
	 /** 
     * 获取外置SD卡的剩余容量 单位byte 
     *  
     * @return 
     */  
    public static long getSecondSDCardAllSize()  
    {  
        if (isSecondSDcardMounted())  
        {  
            StatFs stat = new StatFs(getSecondExterPath());  
            // 获取空闲的数据块的数量  
            long availableBlocks = (long) stat.getAvailableBlocks() - 4;  
            // 获取单个数据块的大小（byte）  
            long freeBlocks = stat.getAvailableBlocks();  
            return freeBlocks * availableBlocks;  
        }  
        return 0;  
    }  
    
	 /** 
     * 获取内置SD卡的剩余容量 单位byte 
     *  
     * @return 
     */  
    public static long getFirstSDCardAllSize()  
    {  
        if (isFirstSdcardMounted())  
        {  
            StatFs stat = new StatFs(getFirstExterPath());  
            // 获取空闲的数据块的数量  
            long availableBlocks = (long) stat.getAvailableBlocks() - 4;  
            // 获取单个数据块的大小（byte）  
            long freeBlocks = stat.getAvailableBlocks();  
            return freeBlocks * availableBlocks;  
        }  
        return 0;  
    }  
  
    /** 
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte 
     *  
     * @param filePath 
     * @return 容量字节 SDCard可用空间，内部存储可用空间 
     */  
    public static long getFreeBytes(String filePath)  
    {  
    	if(filePath.startsWith(getSecondExterPath())){
    		filePath =getSecondExterPath();
    	} else if (filePath.startsWith(getFirstExterPath())) {  
    		// 如果是sd卡的下的路径，则获取sd卡可用容量  
    		filePath = getFirstExterPath();  
    	} else {
    		// 如果是内部存储的路径，则获取内存存储的可用容量  
    		filePath = Environment.getDataDirectory().getAbsolutePath();  
    	}  
    	StatFs stat = new StatFs(filePath);  
    	long availableBlocks = (long) stat.getAvailableBlocks() - 4;  
    	return stat.getBlockSize() * availableBlocks;  
    }  
}

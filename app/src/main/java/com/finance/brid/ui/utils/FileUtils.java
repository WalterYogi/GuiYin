package com.finance.brid.ui.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * Created by wmi01 on 2015年11月5日.
 * 
 * TODO 文件相关类
 */
public class FileUtils {
	/*** 获取文件大小 ***/
	public static long getFileSizes(File f) throws Exception {
		long s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else {
			f.createNewFile();
			System.out.println("文件不存在");
		}
		return s;
	}

	/*** 获取文件夹大小 ***/
	public static long getFileSize1(File f) {
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize1(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}

	/*** 转换文件大小单位(b/kb/mb/gb) 
	 * @throws Exception ***/
	public static String getFileSize(Context context, File f) {// 转换文件大小
		long fileS = getFileSize1(f)+getFileSize1(context.getCacheDir());
//		LogUtils.i(context.getCacheDir().getAbsolutePath());
//		LogUtils.i(f.getAbsolutePath());
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	/*** 获取文件个数 ***/
	public static long getlist(File f) {// 递归求取目录文件个数
		long size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;
	}

	/**
	 * 删除文件夹中所有文件
	 * @param root
	 */
	public static void deleteAllFiles(File root) {
		File files[] = root.listFiles();
		if (files != null)
			for (File f : files) {
				if (f.isDirectory()) { // 判断是否为文件夹
					deleteAllFiles(f);
					try {
						f.delete();
					} catch (Exception e) {
					}
				} else {
					if (f.exists()) { // 判断是否存在
						deleteAllFiles(f);
						try {
							f.delete();
						} catch (Exception e) {
						}
					}
				}
			}
	}
}

package com.finance.brid.ui.utils;

import android.net.Uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by wmi01 on 2015年11月6日.
 * 
 * TODO 字符串工具类
 */
public class StringUtils {

	/**
	 * 判断字符串为空，或长度为零（不包括空格）
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * 判断字符串为空，或长度为零（包括空格）
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * 判断字符串是否相等
	 */
	public static boolean isEquals(String actual, String expected) {
		return ObjectUtils.isEquals(actual, expected);
	}

	/**
	 * 字符串为null,转成长度为0的字符串
	 */
	public static String nullStrToEmpty(String str) {
		return (str == null ? "" : str);
	}

	/**
	 * 将字符串第一个字符转成大写
	 */
	public static String capitalizeFirstLetter(String str) {
		if (isEmpty(str)) {
			return str;
		}

		char c = str.charAt(0);
		return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
				: new StringBuilder(str.length())
						.append(Character.toUpperCase(c))
						.append(str.substring(1)).toString();
	}

	/**
	 * 将字符串编码转成utf-8
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * 将字符串编码转成utf-8,如果出错，则返回defultReturn
	 */
	public static String utf8Encode(String str, String defultReturn) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return defultReturn;
			}
		}
		return str;
	}

	/**
	 * 将url中的...转成utf-8编码
	 */
	public static String encodeUrlPath(String path) {
		String param = path.substring(path.lastIndexOf("/") + 1, path.length());
		StringBuilder urlPreffix = new StringBuilder(path.substring(0,
				path.lastIndexOf("/") + 1));
		urlPreffix.append(Uri.encode(param, "UTF-8"));
		return urlPreffix.toString();
	}

	/**
	 * 处理在html中特殊的字符
	 */
	public static String htmlEscapeCharsToString(String source) {
		return StringUtils.isEmpty(source) ? source : source
				.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
	}

	/**
	 * 全角转为半角
	 */
	public static String fullWidthToHalfWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == 12288) {
				source[i] = ' ';
				// } else if (source[i] == 12290) {
				// source[i] = '.';
			} else if (source[i] >= 65281 && source[i] <= 65374) {
				source[i] = (char) (source[i] - 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * 全角转成半角
	 */
	public static String halfWidthToFullWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == ' ') {
				source[i] = (char) 12288;
				// } else if (source[i] == '.') {
				// source[i] = (char)12290;
			} else if (source[i] >= 33 && source[i] <= 126) {
				source[i] = (char) (source[i] + 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * 将html的标识内容去掉
	 * @param normal
	 * @return
	 */
	public static String EnterStringReplace(String normal){
		String result = normal;
		normal = normal.replaceAll("\t", "");
		while(normal.indexOf("<") != -1){
			int index1 = normal.indexOf("<");
			int index2 = normal.indexOf(">");
			result = normal.substring(0, index1);
			result += normal.substring(index2+1, normal.length());
			normal = result;
		}
		result = result.replaceAll("\n\n\n\n", "\n");
		result = result.replaceAll("\n\n\n", "\n");
		result = result.replaceAll("\n\n", "\n");
		result = result.replaceAll("&amp;", "&");
		result = result.trim();
		int index1 = result.indexOf("\\");
		while(index1==0){
			index1 = result.indexOf("\\");
			result = result.substring(2, result.length());
		}
		return result;
	}
}

package com.finance.brid.ui.utils;

public class FormatUtils {
	
	public static String MsecToTimeFormat(long dsec){
		StringBuffer time = new StringBuffer();;
		String[] hh = new String[3];
		long sec = dsec/1000;
		int i = 0;
		while(i < 3){
			long remainder = sec%60;
			if(remainder<10){
				hh[i] = "0" + String.valueOf(sec%60);
			} else {
				hh[i] = String.valueOf(sec%60);
			}
			sec = sec/60;
			i++;
		}
		if(!"00".equals(hh[2])){
			time.append(hh[2]);
			time.append(":");
		}
		time.append(hh[1]);
		time.append(":");
		time.append(hh[0]);
		return time.toString();
	}
}

package com.baizhi.cmfz.utils;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:14
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dateUtils {
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.util.Date toUtilDate(String s){
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static java.sql.Date toSqlDate(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
	
	public static String toString(java.util.Date utilDate){
		return sdf.format(utilDate);
	}
	
}

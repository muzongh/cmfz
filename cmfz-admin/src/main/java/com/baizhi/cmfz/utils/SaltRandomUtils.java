package com.baizhi.cmfz.utils;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:14
*/

import java.util.Random;

public class SaltRandomUtils {
	public static String getString(int s){
		char[] cs="1234567890qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ".toCharArray();
		char[] salt=new char[s];
		Random random=new Random();
		for (int i = 0; i < salt.length; i++) {
			salt[i]=cs[random.nextInt(cs.length)];
		}
		
		String str=String.valueOf(salt);
		
		
		return str;
	}
}

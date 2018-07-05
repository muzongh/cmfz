package com.baizhi.cmfz.utils;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:14
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageCodeUtils {
	public static char[] getchars(int length){
		char[] chs="0123456789ZXCVBNMLKJHGFDSAQWERTYUIOPpoiuytrewqasdfghjklmnbvcxz".toCharArray();
		char[] code=new char[length];
		
		Random random =new Random();
		for (int i = 0; i < code.length; i++) {
			code[i]=chs[random.nextInt(chs.length)];
		}
		
		return code;
	}
	
	public static BufferedImage getImage(char[] code){
		BufferedImage image=new BufferedImage(90,40, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 90, 40);
		
		g.setColor(Color.red);
		g.drawString(code[0]+"", 10, 25);
		g.drawString(code[1]+"", 30, 25);
		g.drawString(code[2]+"", 50, 25);
		g.drawString(code[3]+"", 70, 25);
		
		g.dispose();
		
		return image;
		
	}
	
}

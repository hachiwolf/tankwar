package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 *  障碍物基类
 * @author timbo
 * @version v1.0
 */
public abstract class Barrier 
{
	public static final int RODE=0;
	public static final int BRICK=1;
	public static final int STONE=2;
	public static final int SEA=3;
	public static final int ICE=4;
	public static final int GRASS=5;
	int x;
	int y;
	Bitmap bitmap;
	/**
	 * 绘制障碍物
	 * @param canvas	画布
	 * @param paint	画笔
	 * @param x	绘制x轴
	 * @param y	绘制y轴
	 */
	abstract void drawSelf(Canvas canvas,Paint paint,int x,int y);
}

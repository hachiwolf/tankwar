package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * ±ùÑ©ÕÏ°­Àà £¨¼Ì³ĞÕÏ°­Îï»ùÀà£©
 * @author timbo
 * @version v1.0
 */
public class Ice extends Barrier
{
	public Ice(Bitmap bitmap)
	{
		this.bitmap=bitmap;
	}
	@Override
	void drawSelf(Canvas canvas, Paint paint,int x,int y) 
	{
		canvas.drawBitmap(bitmap, x,y, paint);
	}

}
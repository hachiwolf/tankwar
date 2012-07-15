package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * 奖励生命类 （继承奖励物类）
 * @author timbo
 * @version v1.0
 */
public class Life extends Reward
{
	public Life(Bitmap bitmap)
	{
		this.bitmap=bitmap;
	}
	@Override
	void drawSelf(Canvas canvas, Paint paint) 
	{
		canvas.drawBitmap(bitmap, x,y, paint);
	}
}

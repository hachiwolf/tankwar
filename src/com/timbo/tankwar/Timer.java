package com.timbo.tankwar;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ½±ÀøÎï£º¶¨Ê±Æ÷£¨Time£©
 * @author timbo
 *
 */
public class Timer extends Reward
{
	public Timer(Bitmap bitmap)
	{
		this.bitmap=bitmap;
	}
	@Override
	void drawSelf(Canvas canvas, Paint paint) 
	{
		canvas.drawBitmap(bitmap, x,y, paint);
	}
}
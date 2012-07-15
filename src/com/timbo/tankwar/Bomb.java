package com.timbo.tankwar;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ը���ࣨ�̳��ڽ������ࣩ
 * @author timbo
 * @version v1.0
 */
public class Bomb extends Reward
{
	public Bomb(Bitmap bitmap)
	{
		this.bitmap=bitmap;
	}
	@Override
	void drawSelf(Canvas canvas, Paint paint) 
	{
		canvas.drawBitmap(bitmap, x,y, paint);
	}
}

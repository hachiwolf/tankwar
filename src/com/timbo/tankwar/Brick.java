package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * 砖块类（继承于障碍物基类）
 * @author timbo
 * @version v1.0
 */
public class Brick extends Barrier
{
	
	public Brick(Bitmap bitmap)
	{
		this.bitmap=bitmap;
	}
	@Override
	void drawSelf(Canvas canvas, Paint paint,int x,int y) 
	{
		canvas.drawBitmap(bitmap, x,y, paint);
	}

}

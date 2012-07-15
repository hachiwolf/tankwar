package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ½±ÀøÎï£ºÌú²ùÀà
 * @author timbo
 *
 */
public class Shovel extends Reward {
	public Shovel(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}
}

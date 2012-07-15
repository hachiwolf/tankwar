package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * 障碍物石头类，(继承障碍物类)
 * @author timbo
 *
 */
public class Stone extends Barrier {
	public Stone(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	void drawSelf(Canvas canvas, Paint paint, int x, int y) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}

}
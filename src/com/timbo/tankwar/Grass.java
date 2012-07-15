package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ’œ∞≠≤›µÿ¿‡ £®ºÃ≥–’œ∞≠ŒÔ¿‡£©
 * 
 * @author timbo
 * @version v1.0
 */
public class Grass extends Barrier {

	public Grass(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	void drawSelf(Canvas canvas, Paint paint, int x, int y) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}

}

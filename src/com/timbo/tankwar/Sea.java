package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * �����ϰ��� ���̳��ϰ����ࣩ
 * @author timbo
 *
 */
public class Sea extends Barrier {
	public Sea(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	void drawSelf(Canvas canvas, Paint paint, int x, int y) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}

}
package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * �����ܲ���
 * @author timbo
 * @version v1.0
 */
public class Home {
	int x;
	int y;
	Bitmap bitmap;

	Home(Bitmap bitmap, int x, int y) {
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
	}
	/**
	 * ����̹���ܲ�
	 * @param canvas ����
	 * @param paint	����
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}
	/**
	 * �ܲ���ը����Ϸ����
	 */
	void explode() {
		this.bitmap = MySurfaceView.homediedBitmap;
		MySurfaceView.overGame();
	}
}

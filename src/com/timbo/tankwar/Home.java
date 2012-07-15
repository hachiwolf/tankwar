package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 老窝总部类
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
	 * 绘制坦克总部
	 * @param canvas 画布
	 * @param paint	画笔
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}
	/**
	 * 总部爆炸，游戏结束
	 */
	void explode() {
		this.bitmap = MySurfaceView.homediedBitmap;
		MySurfaceView.overGame();
	}
}

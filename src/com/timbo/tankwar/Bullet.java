package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * �ӵ��� (���̳��κ���)
 * 
 * @author timbo
 * @version v1.0
 */
public class Bullet {
	/**
	 * ������� 0-up 1-right 2-down 3-left
	 */
	int direction;
	int x;
	int y;
	int span = Constant.TANK_BULLET_SPAN;
	Bitmap bitmap;

	public Bullet(Bitmap bitmap, int direction, int x, int y) {
		this.bitmap = bitmap;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}

	/**
	 * �ж��ܲ����ƶ����µ�λ��
	 * 
	 * @param xTemp
	 * @param yTemp
	 * @return
	 */
	boolean canGo(int xTemp, int yTemp) {
		boolean canGoFlag = true;
		if (!Constant.isBulletInGameView(xTemp, yTemp)) {
			canGoFlag = false;
		}
		Hero hero = MySurfaceView.hero;
		// �ж��ӵ��Ƿ����Ӣ��
		if (Constant.oneIsInAnother(x, y, Constant.BULLET_SIZE,
				Constant.BULLET_SIZE, hero.x, hero.y, Constant.TANK_SIZE,
				Constant.TANK_SIZE)) {
			if (!hero.isProtected()) {
				hero.explode();
			}
			canGoFlag = false;
		}
		// ���̹���Ƿ������ϰ���
		if (MySurfaceView.map.isBulletMetWithBarrier(xTemp, yTemp)) {
			canGoFlag = false;
		}
		return canGoFlag;
	}

	void go() {
		int xTemp = x;
		int yTemp = y;

		// �ӵ��н�
		switch (direction) {
		case Tank.DERECTION_UP:
			yTemp = y - span;
			break;
		case Tank.DERECTION_DOWN:
			yTemp = y + span;
			break;
		case Tank.DERECTION_RIGHT:
			xTemp = x + span;
			break;
		case Tank.DERECTION_LEFT:
			xTemp = x - span;
			break;
		}
		if (canGo(xTemp, yTemp))// �ж��ܲ����ƶ����µ�λ��
		{
			x = xTemp;
			y = yTemp;
			// �ӵ��ߵ���λ�ú��ж��Ƿ��������
			if (MySurfaceView.map.isBulletMetWithHome(x, y)) {
				this.explode();
				MySurfaceView.map.home.explode();
			}
		} else {
			explode();
		}
	}

	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}

	void explode() {
		MySurfaceView.alBullet.remove(this);
	}
}

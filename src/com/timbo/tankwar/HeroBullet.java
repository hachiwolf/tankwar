package com.timbo.tankwar;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Ӣ���ӵ���
 * @author timbo
 * @version v1.0
 *
 */
public class HeroBullet {
	/**
	 * �ӵ��˶����� 0-up 1-right 2-down 3-left
	 */
	int direction;
	int x;
	int y;
	/**
	 * Ӣ���ӵ��ٶ�
	 */
	int span = Constant.HERO_BULLET_INIT_SPAN;
	Bitmap bitmap;

	public HeroBullet(Bitmap bitmap, int direction, int x, int y) {
		this.bitmap = bitmap;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}

	/**
	 * �ж��ܲ����ƶ����µ�λ��
	 * 
	 * @param xTemp �µ�X����
	 * @param yTemp �µ�Y����
	 * @return true �ܣ�false ����
	 */
	boolean canGo(int xTemp, int yTemp) {
		boolean canGoFlag = true;
		// �ж��ӵ��Ƿ�ɳ��߽�
		if (!Constant.isBulletInGameView(xTemp, yTemp)) {
			canGoFlag = false;
		}
		// �ж��ӵ��Ƿ���е���̹��

		ArrayList<Tank> alTank = new ArrayList<Tank>(MySurfaceView.alTank);
		for (Tank t : alTank) {
			if (Constant.oneIsInAnother(x, y, Constant.BULLET_SIZE,
					Constant.BULLET_SIZE, t.x, t.y, Constant.TANK_SIZE,
					Constant.TANK_SIZE))// �ж��Ƿ���е�̹��
			{
				if (!t.lifeMinusOne()) {
					t.explode();
				}
				canGoFlag = false;
			}
		}
		ArrayList<Bullet> alBullet = new ArrayList<Bullet>(
				MySurfaceView.alBullet);
		for (Bullet b : alBullet) {
			if (Constant.oneIsInAnother(x, y, Constant.BULLET_SIZE,
					Constant.BULLET_SIZE, b.x, b.y, Constant.BULLET_SIZE,
					Constant.BULLET_SIZE))// �ж��Ƿ�����ӵ���ײ
			{
				b.explode();
				canGoFlag = false;
			}
		}
		// ����ӵ��Ƿ������ϰ���
		if (MySurfaceView.map.isBulletMetWithBarrier(xTemp, yTemp)) {
			canGoFlag = false;
		}
		return canGoFlag;
	}
	/**
	 * �ӵ��ƶ�
	 */
	void go() {
		int xTemp = x;
		int yTemp = y;

		// �ӵ��н�
		switch (direction) {
		case 0:
			yTemp = y - span;
			break;
		case 2:
			yTemp = y + span;
			break;
		case 1:
			xTemp = x + span;
			break;
		case 3:
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
	/**
	 * ����Ӣ���ӵ�
	 * @param canvas ����
	 * @param paint ����
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}
	/**
	 * �ӵ���ը
	 */
	protected void explode() {
		MySurfaceView.alHeroBullet.remove(this);
	}
}

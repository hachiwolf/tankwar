package com.timbo.tankwar;

import static com.timbo.tankwar.Constant.GAME_VIEW_HEIGHT;
import static com.timbo.tankwar.Constant.GAME_VIEW_WIDTH;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * �з�̹����
 * @author timbo
 * @version v1.0
 */
public class Tank {
	public static final int DERECTION_UP = 0;
	public static final int DERECTION_RIGHT = 1;
	public static final int DERECTION_DOWN = 2;
	public static final int DERECTION_LEFT = 3;

	Bitmap[] tanki;
	int direction;
	int x;
	int y;
	int span = 2;
	int life = 1;

	public Tank(Bitmap[] tanki, int span, int life, int direction, int x, int y) {
		this.tanki = tanki;
		this.span = span;
		this.life = life;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}

	public Tank(int direction, int x, int y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
	/**
	 * �з�̹������ֵ��1
	 * @return ���ɹ����򷵻�false��or ����true
	 */
	boolean lifeMinusOne()
	{
		if (life > 1) {
			life--;
			return true;
		}
		return false;
	}
	/**
	 * �з�̹�����з���
	 */
	void go() {
		int xTemp = x;
		int yTemp = y;

		switch (direction)// �жϵ�ǰ̹�˵��˶�����
		{
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
		} else// �����ƶ�����ת��
		{
			this.sendBullet();
			this.changeDirection();
			// go();//�ݹ���û����쳣
		}
	}
	/**
	 *  �жϵз�̹���ܲ����ƶ����µ�λ��
	 * @param xTemp �µ�X����
	 * @param yTemp	�µ�Y����
	 * @return
	 */
	boolean canGo(int xTemp, int yTemp)
	{
		boolean canGoFlag = true;
		// ���̹�ˣ�����Ӣ��̹�ˣ�����Ϸ������
		if (!Constant.isTankInGameView(xTemp, yTemp)) {
			canGoFlag = false;
		}
		// ���з�̹��֮���Ƿ�����ײ
		ArrayList<Tank> alTank = new ArrayList<Tank>(MySurfaceView.alTank);
		for (Tank t : alTank) {
			if (t != this
					&& Constant.oneIsInAnother(xTemp, yTemp,
							Constant.TANK_SIZE, Constant.TANK_SIZE, t.x, t.y,
							Constant.TANK_SIZE, Constant.TANK_SIZE)) {
				canGoFlag = false;
			}
		}
		if (Constant.oneIsInAnother(xTemp, yTemp, Constant.TANK_SIZE,
				Constant.TANK_SIZE, MySurfaceView.hero.x,
				MySurfaceView.hero.y, Constant.TANK_SIZE,
				Constant.TANK_SIZE)) {
			canGoFlag = false;
		}
		// ���̹���Ƿ������ϰ���
		if (MySurfaceView.map.isTankMetWithBarrier(xTemp, yTemp)) {
			canGoFlag = false;
		}
		return canGoFlag;
	}
	/**
	 * �ı�з�̹�����з���
	 */
	void changeDirection() {
		if (Math.random() <= Constant.TANK_CHANGE_DIRECTION_POSSIBILITY)// ����õ������С����ֵʱ���ı�̹�˷���
		{
			if (x > 0 || x < GAME_VIEW_WIDTH || y > 0
					|| y < GAME_VIEW_HEIGHT - Constant.TANK_SIZE)// �жϵ�ǰ̹���Ƿ��ڽ�����
			{
				int random = (int) (Math.random() * Constant.VALUE_TANK_GO_DOWN);// ����ı�̹�˷���
				if (random > 3) {
					direction = Tank.DERECTION_DOWN;
				} else {
					this.direction = random;
				}
			}
		}
	}
	/**
	 * �з�̹�˷����ӵ�
	 * @return �ӵ���-Bullet
	 */
	Bullet sendBullet() {
		int direction = this.direction;// ��õ�ǰ��̹�˵��˶������λ��
		int x = this.x;
		int y = this.y;

		switch (direction)// ��ʼ���ӵ��ĳ�ʼλ��
		{
		case Tank.DERECTION_UP:// up
			x = x + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			y = y - Constant.BULLET_SIZE / 2 + 1;
			break;
		case Tank.DERECTION_DOWN:// down
			x = x + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			y = y + Constant.TANK_SIZE - Constant.BULLET_SIZE / 2 - 1;
			break;
		case Tank.DERECTION_RIGHT:// right
			x = x + Constant.TANK_SIZE - Constant.BULLET_SIZE / 2 - 1;
			y = y + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			break;
		case Tank.DERECTION_LEFT:// left
			x = x - Constant.BULLET_SIZE / 2 + 1;
			y = y + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			break;
		}

		return new Bullet(MySurfaceView.bullet, direction, x, y);// �����µĵ��ӵ�
	}
	/**
	 * ���Ƶз�̹��
	 * @param canvas	����
	 * @param paint	����
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(tanki[direction], x, y, paint);
	}
	/**
	 * �з�̹�˱�ը
	 */
	void explode() {
		MySurfaceView.alTank.remove(this);
		MySurfaceView.countTankDestoryed = MySurfaceView.countTankDestoryed + 1;
		if (MySurfaceView.isCurrentMissionCompleted()) {
			MySurfaceView.map.goToNextMission();
		}
	}
}
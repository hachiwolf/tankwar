package com.timbo.tankwar;

import static com.timbo.tankwar.Constant.*;

import java.util.ArrayList;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Ӣ��̹����
 * 
 * @author timbo
 * @version v1.0
 */
public class Hero {
	/**
	 * ��ʾӢ��״̬�ĳ��� (������ǵ�����)
	 */
	public static final int WITH_NOTHING = 0;
	public static final int WITH_ONE_STAR = 1;
	public static final int WITH_TWO_STARS = 2;
	public static final int WITH_MORE_STARS = 3;
	/**
	 * Ӣ�� ����
	 */
	static int HEROLIFE = Constant.HERO_LIFE;
	/**
	 * Ӣ��̹���˶����� 0-up 1-right 2-down 3-left
	 */
	int direction = 0;
	int initX;
	int initY;
	int x;
	int y;
	/**
	 * Ӣ��̹���˶��ٶ�
	 */
	int span = Constant.HERO_SPAN;
	/**
	 * ������ǵ�����
	 */
	int heroState = Hero.WITH_NOTHING;
	/**
	 * �����ǵ�����
	 */
	int starCount = 0;
	/**
	 * Ӣ���ӵ��������
	 */
	int heroBulletMaxNum = Constant.HERO_BULLET_INIT_MAX_NUM;
	Bitmap[] tanki;
	/**
	 * Ӣ��̹�˱��������
	 */
	Bitmap coveringBitmap = MySurfaceView.coveringBitmap;
	/**
	 * ��ʱ�̵߳�����
	 */
	StopTankForAMomentThread stopThread = null;
	/**
	 * ��ʯǽ����������һ��ʱ����̵߳�����
	 */
	BuildHomeThread buildThread = null;
	/**
	 * ����̹�˵��߳�����
	 */
	ProtectHeroThread protectThread = null;
	/**
	 * ̹�˱������ı�־λ
	 */
	private boolean isprotectedFlag = false;

	public Hero(Bitmap[] tanki) {
		this.tanki = tanki;
		initX = GAME_VIEW_WIDTH / 2 - 4 * Constant.BARRIER_SIZE - 8
				+ Constant.GAME_VIEW_X;
		initY = GAME_VIEW_HEIGHT - Constant.TANK_SIZE
				+ Constant.GAME_VIEW_Y;
		x = initX;
		y = initY;
	}

	/**
	 * �ж�Ӣ��̹���ܲ����ƶ����µ�λ��
	 * 
	 * @param xTemp
	 *            X����
	 * @param yTemp
	 *            Y����
	 * @return true �ܣ�false ����
	 */
	boolean canGo(int xTemp, int yTemp) {
		boolean canGoFlag = true;
		// ����Ƿ�����Ļ��
		if (!Constant.isHeroInGameView(xTemp, yTemp)) {
			canGoFlag = false;
		}
		// ����Ƿ���з�̹����ײ
		ArrayList<Tank> alTank = new ArrayList<Tank>(MySurfaceView.alTank);
		for (Tank t : alTank) {
			if (Constant.oneIsInAnother(xTemp + Constant.TANK_SIZE_REVISE,
					yTemp + Constant.TANK_SIZE_REVISE, Constant.TANK_SIZE - 2
							* Constant.TANK_SIZE_REVISE, Constant.TANK_SIZE - 2
							* Constant.TANK_SIZE_REVISE, t.x
							+ Constant.TANK_SIZE_REVISE, t.y
							+ Constant.TANK_SIZE_REVISE, Constant.TANK_SIZE - 2
							* Constant.TANK_SIZE_REVISE, Constant.TANK_SIZE - 2
							* Constant.TANK_SIZE_REVISE)) {
				canGoFlag = false;
			}
		}
		// ���̹���Ƿ������ϰ���
		if (MySurfaceView.map.isTankMetWithBarrier(xTemp, yTemp)) {
			canGoFlag = false;
		}
		return canGoFlag;
	}

	/**
	 * Ӣ��̹���ƶ�
	 */
	void go() {
		int xTemp = x;
		int yTemp = y;
		if ((MySurfaceView.keyState & 0x1) != 0)// up
		{
			direction = Tank.DERECTION_UP;
			yTemp = y - span;
		} else if ((MySurfaceView.keyState & 0x2) != 0)// down
		{
			direction = Tank.DERECTION_DOWN;
			yTemp = y + span;
		} else if ((MySurfaceView.keyState & 0x4) != 0)// left
		{
			direction = Tank.DERECTION_LEFT;
			xTemp = x - span;
		} else if ((MySurfaceView.keyState & 0x8) != 0)// right
		{
			direction = Tank.DERECTION_RIGHT;
			xTemp = x + span;
		}
		if (canGo(xTemp, yTemp))// �ж��ܲ����ƶ����µ�λ��
		{
			// ���̹���Ƿ��ڱ��ϴ�
			if (MySurfaceView.map.isHeroMetWithIce(this)) {// ��ǰ�������һ�ξ���
				if (y == yTemp) {
					int vx = xTemp - x;
					xTemp += vx;
				} else {
					int vy = yTemp - y;
					yTemp += vy;
				}
			}
			x = xTemp;
			y = yTemp;
		}
		if (MySurfaceView.map.isHeroMetWithReward(this)) {
			this.getTheReward(MySurfaceView.map.reward);
			// ���������
			MySurfaceView.map.reward = null;
			// �Ե��������һ��
			MySurfaceView.score += 1;
		}
	}
	/**
	 * Ӣ��̹�˷����ӵ�
	 * @return HeroBullet Ӣ���ӵ�
	 */
	HeroBullet sendBullet() {
		HeroBullet result = null;
		int direction = this.direction;// ��õ�ǰ��̹�˵��˶������λ��
		int x = this.x;
		int y = this.y;

		switch (direction)// ��ʼ���ӵ��ĳ�ʼλ��
		{
		case Tank.DERECTION_UP:// up
			x = x + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			y = y - Constant.BULLET_SIZE / 2;
			break;
		case Tank.DERECTION_DOWN:// down
			x = x + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			y = y + Constant.TANK_SIZE - Constant.BULLET_SIZE / 2;
			break;
		case Tank.DERECTION_RIGHT:// right
			x = x + Constant.TANK_SIZE - Constant.BULLET_SIZE / 2;
			y = y + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			break;
		case Tank.DERECTION_LEFT:// left
			x = x - Constant.BULLET_SIZE / 2;
			y = y + Constant.TANK_SIZE / 2 - Constant.BULLET_SIZE / 2 - 1;
			break;
		}
		switch (this.heroState) {
		case Hero.WITH_NOTHING:
			result = new HeroBulletNormal(direction, x, y);
			break;
		case Hero.WITH_ONE_STAR:
		case Hero.WITH_TWO_STARS:
			result = new HeroBulletFast(direction, x, y);
			break;
		case Hero.WITH_MORE_STARS:
			result = new HeroBulletFastAndStrong(direction, x, y);
			break;
		}
		return result;// �����µĵ��ӵ�
	}

	/**
	 * Ӣ��̹�˱��з�̹�˻���(��ը)
	 */
	void explode() {
		Hero.HEROLIFE--;
		if (Hero.HEROLIFE == 0) {
			MySurfaceView.overGame();
		} else {
			try {
				Thread.sleep(100);// һ��ʱ�������
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.backHome();
			MySurfaceView.hero = new Hero(MySurfaceView.heroTanki1);
		}
	}
	/**
	 * Ӣ��̹�˻�ý�����
	 * @param reward ������
	 */
	void getTheReward(Reward reward) {
		//�Ե�����
		if (reward.getClass() == Star.class) {
			if (this.starCount == 0) {
				this.starCount++;
				this.heroState = Hero.WITH_ONE_STAR;
				this.tanki = MySurfaceView.heroTanki2;
			} else if (this.starCount == 1) {
				this.starCount++;
				this.heroState = Hero.WITH_TWO_STARS;
				this.heroBulletMaxNum = Constant.HERO_BULLET_MAX_NUM_MORE;
				this.tanki = MySurfaceView.heroTanki3;
			} else if (this.starCount >= 2) {
				this.heroState = Hero.WITH_MORE_STARS;
				this.heroBulletMaxNum = Constant.HERO_BULLET_MAX_NUM_MORE;
				this.tanki = MySurfaceView.heroTanki4;
			}
		} else if (reward.getClass() == Bomb.class) {// �Ե�ը��
			ArrayList<Tank> alTank = new ArrayList<Tank>(
					MySurfaceView.alTank);// ��õ�ǰ�Ѵ��ڵ�̹�˴���б�
			for (Tank t : alTank) {
				t.explode();
			}

		} else if (reward instanceof Life) {// �Ե���
			Hero.HEROLIFE++;
		} else if (reward instanceof Shovel) {// �Ե�����
												// ������ʯǽ����������һ��ʱ����߳�
			if (buildThread == null || !buildThread.isAlive()) {
				buildThread = new BuildHomeThread();
				buildThread.start();
			}
		} else if (reward instanceof Protector) {// �Ե�������
													// ��������Ӣ��̹���߳�
			if (protectThread == null || !protectThread.isAlive()) {
				protectThread = new ProtectHeroThread(this);
				protectThread.start();
			}
		} else if (reward instanceof Timer) {// �Ե���ʱ��
			// ������ʱ�߳�
			if (stopThread == null || !stopThread.isAlive()) {
				stopThread = new StopTankForAMomentThread();
				stopThread.start();
			}
		}
	}
	
	/**
	 * ����Ӣ��̹��
	 * @param canvas ����
	 * @param paint ����
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(tanki[direction], x, y, paint);
		if (this.isProtected()) {
			canvas.drawBitmap(coveringBitmap, x, y, paint);
		}
	}

	/**
	 *  ���ϱ������ķ���
	 */
	void wearProtector() {
		isprotectedFlag = true;
	}

	/**
	 *  ȥ���������ķ���
	 */
	void removeProtector() {
		isprotectedFlag = false;
	}

	/**
	 *  ���̹���Ƿ񱻱����ķ���
	 * @return true ��������false û����
	 */
	boolean isProtected() {
		return isprotectedFlag;
	}

	/**
	 *  ̹�˻ص���ʼλ�õķ���
	 */
	void backHome() {
		this.x = initX;
		this.y = initY;
		this.direction = Tank.DERECTION_UP;
		MySurfaceView.keyState = 0;
	}
}

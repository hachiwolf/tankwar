package com.timbo.tankwar;

import static com.timbo.tankwar.Constant.*;

import java.util.ArrayList;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 英雄坦克类
 * 
 * @author timbo
 * @version v1.0
 */
public class Hero {
	/**
	 * 表示英雄状态的常量 (获得星星的数量)
	 */
	public static final int WITH_NOTHING = 0;
	public static final int WITH_ONE_STAR = 1;
	public static final int WITH_TWO_STARS = 2;
	public static final int WITH_MORE_STARS = 3;
	/**
	 * 英雄 生命
	 */
	static int HEROLIFE = Constant.HERO_LIFE;
	/**
	 * 英雄坦克运动方向 0-up 1-right 2-down 3-left
	 */
	int direction = 0;
	int initX;
	int initY;
	int x;
	int y;
	/**
	 * 英雄坦克运动速度
	 */
	int span = Constant.HERO_SPAN;
	/**
	 * 获得星星的数量
	 */
	int heroState = Hero.WITH_NOTHING;
	/**
	 * 吃星星的数量
	 */
	int starCount = 0;
	/**
	 * 英雄子弹最大数量
	 */
	int heroBulletMaxNum = Constant.HERO_BULLET_INIT_MAX_NUM;
	Bitmap[] tanki;
	/**
	 * 英雄坦克保护器外壳
	 */
	Bitmap coveringBitmap = MySurfaceView.coveringBitmap;
	/**
	 * 定时线程的引用
	 */
	StopTankForAMomentThread stopThread = null;
	/**
	 * 用石墙将保护老窝一段时间的线程的引用
	 */
	BuildHomeThread buildThread = null;
	/**
	 * 保护坦克的线程引用
	 */
	ProtectHeroThread protectThread = null;
	/**
	 * 坦克保护器的标志位
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
	 * 判断英雄坦克能不能移动到新的位置
	 * 
	 * @param xTemp
	 *            X坐标
	 * @param yTemp
	 *            Y坐标
	 * @return true 能，false 不能
	 */
	boolean canGo(int xTemp, int yTemp) {
		boolean canGoFlag = true;
		// 检测是否在屏幕内
		if (!Constant.isHeroInGameView(xTemp, yTemp)) {
			canGoFlag = false;
		}
		// 检测是否与敌方坦克碰撞
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
		// 检测坦克是否遇到障碍物
		if (MySurfaceView.map.isTankMetWithBarrier(xTemp, yTemp)) {
			canGoFlag = false;
		}
		return canGoFlag;
	}

	/**
	 * 英雄坦克移动
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
		if (canGo(xTemp, yTemp))// 判断能不能移动到新的位置
		{
			// 检测坦克是否在冰上打滑
			if (MySurfaceView.map.isHeroMetWithIce(this)) {// 沿前进方向打滑一段距离
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
			// 清除奖励物
			MySurfaceView.map.reward = null;
			// 吃到奖励物加一分
			MySurfaceView.score += 1;
		}
	}
	/**
	 * 英雄坦克发射子弹
	 * @return HeroBullet 英雄子弹
	 */
	HeroBullet sendBullet() {
		HeroBullet result = null;
		int direction = this.direction;// 获得当前敌坦克的运动方向和位置
		int x = this.x;
		int y = this.y;

		switch (direction)// 初始化子弹的初始位置
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
		return result;// 创建新的敌子弹
	}

	/**
	 * 英雄坦克被敌方坦克击中(爆炸)
	 */
	void explode() {
		Hero.HEROLIFE--;
		if (Hero.HEROLIFE == 0) {
			MySurfaceView.overGame();
		} else {
			try {
				Thread.sleep(100);// 一定时间后重生
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.backHome();
			MySurfaceView.hero = new Hero(MySurfaceView.heroTanki1);
		}
	}
	/**
	 * 英雄坦克获得奖励物
	 * @param reward 奖励物
	 */
	void getTheReward(Reward reward) {
		//吃到星星
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
		} else if (reward.getClass() == Bomb.class) {// 吃到炸弹
			ArrayList<Tank> alTank = new ArrayList<Tank>(
					MySurfaceView.alTank);// 获得当前已存在敌坦克存放列表
			for (Tank t : alTank) {
				t.explode();
			}

		} else if (reward instanceof Life) {// 吃到命
			Hero.HEROLIFE++;
		} else if (reward instanceof Shovel) {// 吃到铁锹
												// 开启用石墙将保护老窝一段时间的线程
			if (buildThread == null || !buildThread.isAlive()) {
				buildThread = new BuildHomeThread();
				buildThread.start();
			}
		} else if (reward instanceof Protector) {// 吃到保护器
													// 开启保护英雄坦克线程
			if (protectThread == null || !protectThread.isAlive()) {
				protectThread = new ProtectHeroThread(this);
				protectThread.start();
			}
		} else if (reward instanceof Timer) {// 吃到定时器
			// 开启定时线程
			if (stopThread == null || !stopThread.isAlive()) {
				stopThread = new StopTankForAMomentThread();
				stopThread.start();
			}
		}
	}
	
	/**
	 * 绘制英雄坦克
	 * @param canvas 画板
	 * @param paint 画笔
	 */
	void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawBitmap(tanki[direction], x, y, paint);
		if (this.isProtected()) {
			canvas.drawBitmap(coveringBitmap, x, y, paint);
		}
	}

	/**
	 *  穿上保护器的方法
	 */
	void wearProtector() {
		isprotectedFlag = true;
	}

	/**
	 *  去掉保护器的方法
	 */
	void removeProtector() {
		isprotectedFlag = false;
	}

	/**
	 *  检测坦克是否被保护的方法
	 * @return true 被保护，false 没保护
	 */
	boolean isProtected() {
		return isprotectedFlag;
	}

	/**
	 *  坦克回到初始位置的方法
	 */
	void backHome() {
		this.x = initX;
		this.y = initY;
		this.direction = Tank.DERECTION_UP;
		MySurfaceView.keyState = 0;
	}
}

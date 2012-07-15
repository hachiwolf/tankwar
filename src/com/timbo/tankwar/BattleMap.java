package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * �ؿ���ͼ��
 * 
 * @author timbo
 * 
 */
public class BattleMap {
	/**
	 * ���������ؿ��ĵ�ͼ
	 */
	private final byte[][][] MAP_SP = {

	{// crazy tank �ؿ����룺 ����30�� ������23
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 5, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 5, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0,
					0 },
			{ 0, 0, 0, 5, 5, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 0, 5, 5, 0, 0,
					0 },
			{ 0, 0, 3, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 3, 0,
					0 },
			{ 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3,
					0 },
			{ 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0,
					0 },
			{ 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0,
					0 },
			{ 0, 0, 0, 0, 5, 5, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 5, 5, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 3, 0, 3, 0, 3, 0, 5, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0,
					0 },
			{ 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,
					0 },
			{ 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0,
					0 },
			{ 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0,
					0 },
			{ 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
					0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
					0 } } };
	/**
	 * ���к����ؿ��ĵ�ͼ
	 */
	private final byte[][][] MAP_HP = { {// crazy tank �ؿ����� ��������23�� ������30��
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 2, 2, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0,
					1, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0,
					1, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 5, 5, 1, 1, 0, 0, 0, 0,
					1, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 5, 5, 5, 5, 5, 5, 2, 2, 0, 0,
					1, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 5, 5, 5, 5, 1, 1, 5, 5, 5, 5, 1, 1,
					2, 2, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 2, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5,
					2, 2, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 2, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5,
					5, 5, 2, 2, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					5, 5, 5, 5, 1, 1, 0, 0 },
			{ 0, 0, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 5, 5, 5, 5, 0, 0 },
			{ 2, 2, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 5, 5, 2, 2 },
			{ 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 5, 5, 5, 5 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0,
					1, 1, 1, 1, 5, 5, 0, 0 },
			{ 0, 0, 5, 5, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0,
					1, 1, 1, 1, 5, 5, 0, 0 } } };
	/**
	 * ��ǰ�ؿ���
	 */
	private int missionNum = 1;
	/**
	 * ��ǰ�ؿ��ĵ�ͼ
	 */
	private byte[][] mapData; // ע�⣬��ͼ����Ϊbyte����
	private Bitmap brickBitmap = MySurfaceView.brickBitmap;
	private Bitmap stoneBitmap = MySurfaceView.stoneBitmap;
	private Bitmap seaBitmap = MySurfaceView.seaBitmap;
	private Bitmap iceBitmap = MySurfaceView.iceBitmap;
	private Bitmap grassBitmap = MySurfaceView.grassBitmap;
	private Bitmap homeBitmap = MySurfaceView.homeBitmap;
	private Barrier[] barrier = { new Rode(),// 0����·
			new Brick(brickBitmap),// 1����שǽ
			new Stone(stoneBitmap),// 2����ʯǽ
			new Sea(seaBitmap),// 3������
			new Ice(iceBitmap),// 4�����
			new Grass(grassBitmap),// 5����ݵأ������ϲ�
	};
	/**
	 * �������Ѷ���
	 */
	int xHome;// ���ѵ�x,y����
	int yHome;
	Home home;
	/**
	 * ������
	 */
	Reward reward = null;

	void intiMapData() {
		mapData = copyMapData(MAP_HP[missionNum - 1]);
		// �������Ѷ���
		xHome = (mapData[0].length / 2 - 1) * Constant.BARRIER_SIZE
				+ Constant.GAME_VIEW_X;// ���ѵ�x,y����
		yHome = (mapData.length - 2) * Constant.BARRIER_SIZE
				+ Constant.GAME_VIEW_Y;
		home = new Home(homeBitmap, xHome, yHome);

	}

	// ������ά��ͼ����ķ���
	byte[][] copyMapData(byte[][] mapData) {
		byte[][] result = null;
		result = new byte[mapData.length][mapData[0].length];
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[0].length; j++) {
				result[i][j] = mapData[i][j];
			}
		}
		return result;
	}

	/**
	 * Ҫ�����²��
	 * 
	 * @param canvas
	 * @param paint
	 */
	void drawSelfBelow(Canvas canvas, Paint paint) {
		for (int i = 0; i < mapData.length; i++)// ���ϰ���
		{
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] != Barrier.GRASS)// �����²�Ĵ���
				{
					barrier[mapData[i][j]].drawSelf(canvas, paint, j
							* Constant.BARRIER_SIZE + Constant.GAME_VIEW_X, i
							* Constant.BARRIER_SIZE + Constant.GAME_VIEW_Y);
				}
			}
		}
		home.drawSelf(canvas, paint);// ������
	}

	/**
	 * Ҫ�����ϲ��
	 * 
	 * @param canvas
	 * @param paint
	 */
	void drawSelfAbove(Canvas canvas, Paint paint) {
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] == Barrier.GRASS)// �����ϲ�Ĵ���
				{
					barrier[mapData[i][j]].drawSelf(canvas, paint, j
							* Constant.BARRIER_SIZE + Constant.GAME_VIEW_X, i
							* Constant.BARRIER_SIZE + Constant.GAME_VIEW_Y);
				}
			}
		}
		if (reward != null) {
			reward.drawSelf(canvas, paint);
		}
	}

	/**
	 * ���̹�ˣ�����Ӣ��̹�ˣ��Ƿ������ϰ���ķ���
	 * 
	 * @param xTemp
	 * @param yTemp
	 * @return
	 */
	boolean isTankMetWithBarrier(int xTemp, int yTemp) {
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] == Barrier.BRICK
						|| mapData[i][j] == Barrier.STONE
						|| mapData[i][j] == Barrier.SEA) {// ��������ϰ��
					if (Constant.oneIsInAnother// ���������ֵ�ǳ���Ҫ������
							(xTemp + Constant.TANK_SIZE_REVISE - 1, yTemp
									+ Constant.TANK_SIZE_REVISE - 1,
									Constant.TANK_SIZE - 2
											* Constant.TANK_SIZE_REVISE - 3,
									Constant.TANK_SIZE - 2
											* Constant.TANK_SIZE_REVISE - 3, j
											* Constant.BARRIER_SIZE
											+ Constant.GAME_VIEW_X, i
											* Constant.BARRIER_SIZE
											+ Constant.GAME_VIEW_Y,
									Constant.BARRIER_SIZE,
									Constant.BARRIER_SIZE)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Ӣ��̹���Ƿ��ڱ��ϴ� (ֻ��Ӣ��̹�˲��ڱ��ϴ򻬣��з�̹�˲���)
	 * 
	 * @param hero
	 * @return
	 */
	boolean isHeroMetWithIce(Hero hero) {
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] == Barrier.ICE) {// ��������ϰ��
					if (Constant.oneIsInAnother(hero.x, hero.y,
							Constant.TANK_SIZE, Constant.TANK_SIZE, j
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_X, i
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_Y,
							Constant.BARRIER_SIZE, Constant.BARRIER_SIZE)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * �ӵ��Ƿ�����ϰ���
	 * 
	 * @param xTemp
	 * @param yTemp
	 * @return
	 */
	boolean isBulletMetWithBarrier(int xTemp, int yTemp) {
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] == Barrier.BRICK
						|| mapData[i][j] == Barrier.STONE) {// ��������ϰ��
					if (Constant.oneIsInAnother(xTemp, yTemp,
							Constant.BULLET_SIZE, Constant.BULLET_SIZE, j
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_X, i
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_Y,
							Constant.BARRIER_SIZE, Constant.BARRIER_SIZE)) {
						if (mapData[i][j] == Barrier.BRICK)// ��ש����
						{
							mapData[i][j] = Barrier.RODE;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * ��ǿ�ӵ��Ƿ�����ϰ���
	 * 
	 * @param xTemp
	 * @param yTemp
	 * @return
	 */
	boolean isStrongBulletMetWithBarrier(int xTemp, int yTemp) {
		for (int i = 0; i < mapData.length; i++) {
			for (int j = 0; j < mapData[i].length; j++) {
				if (mapData[i][j] == Barrier.BRICK
						|| mapData[i][j] == Barrier.STONE) {// ��������ϰ��
					if (Constant.oneIsInAnother(xTemp, yTemp,
							Constant.BULLET_SIZE, Constant.BULLET_SIZE, j
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_X, i
									* Constant.BARRIER_SIZE
									+ Constant.GAME_VIEW_Y,
							Constant.BARRIER_SIZE, Constant.BARRIER_SIZE)) {
						if (mapData[i][j] == Barrier.BRICK)// ��ש����
						{
							mapData[i][j] = Barrier.RODE;
						}
						if (mapData[i][j] == Barrier.STONE)// ��ש����(ʯͷ)
						{
							mapData[i][j] = Barrier.RODE;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * �ӵ��Ƿ��������
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isBulletMetWithHome(int x, int y) {
		if (Constant.oneIsInAnother(x, y, Constant.BULLET_SIZE,
				Constant.BULLET_SIZE, home.x, home.y, Constant.HOME_SIZE,
				Constant.HOME_SIZE)) {
			return true;
		}

		return false;
	}

	/**
	 * Ӣ��̹���Ƿ�Ե�������
	 * 
	 * @param hero
	 * @return
	 */
	boolean isHeroMetWithReward(Hero hero) {
		if (reward != null
				&& Constant.oneIsInAnother(hero.x, hero.y, Constant.TANK_SIZE,
						Constant.TANK_SIZE, reward.x, reward.y,
						Constant.REWARD_SIZE, Constant.REWARD_SIZE)) {
			return true;
		}
		return false;
	}

	/**
	 * ��ʯǽ�����ѱ��������ķ���
	 */
	void buildHomeWithStone() {
		int row = mapData.length;
		int col = mapData[0].length;
		// ��ʼ��שǽ����������
		mapData[row - 1][col / 2 - 2] = Barrier.STONE;// ��
		mapData[row - 1][col / 2 - 3] = Barrier.STONE;
		mapData[row - 2][col / 2 - 2] = Barrier.STONE;
		mapData[row - 2][col / 2 - 3] = Barrier.STONE;

		mapData[row - 1][col / 2 + 1] = Barrier.STONE;// ��
		mapData[row - 1][col / 2 + 2] = Barrier.STONE;
		mapData[row - 2][col / 2 + 1] = Barrier.STONE;
		mapData[row - 2][col / 2 + 2] = Barrier.STONE;

		mapData[row - 3][col / 2 - 2] = Barrier.STONE;// ����
		mapData[row - 3][col / 2 - 3] = Barrier.STONE;
		mapData[row - 4][col / 2 - 2] = Barrier.STONE;
		mapData[row - 4][col / 2 - 3] = Barrier.STONE;

		mapData[row - 3][col / 2 + 1] = Barrier.STONE;// ����
		mapData[row - 3][col / 2 + 2] = Barrier.STONE;
		mapData[row - 4][col / 2 + 1] = Barrier.STONE;
		mapData[row - 4][col / 2 + 2] = Barrier.STONE;

		mapData[row - 3][col / 2 - 1] = Barrier.STONE;// ��
		mapData[row - 3][col / 2] = Barrier.STONE;
		mapData[row - 4][col / 2 - 1] = Barrier.STONE;
		mapData[row - 4][col / 2] = Barrier.STONE;
	}

	/**
	 * ��ש�齫���ѱ��������ķ���
	 */
	void buildHomeWithBrick() {
		int row = mapData.length;
		int col = mapData[0].length;
		// ��ʼ��שǽ����������
		mapData[row - 1][col / 2 - 2] = Barrier.BRICK;// ��
		mapData[row - 1][col / 2 - 3] = Barrier.BRICK;
		mapData[row - 2][col / 2 - 2] = Barrier.BRICK;
		mapData[row - 2][col / 2 - 3] = Barrier.BRICK;

		mapData[row - 1][col / 2 + 1] = Barrier.BRICK;// ��
		mapData[row - 1][col / 2 + 2] = Barrier.BRICK;
		mapData[row - 2][col / 2 + 1] = Barrier.BRICK;
		mapData[row - 2][col / 2 + 2] = Barrier.BRICK;

		mapData[row - 3][col / 2 - 2] = Barrier.BRICK;// ����
		mapData[row - 3][col / 2 - 3] = Barrier.BRICK;
		mapData[row - 4][col / 2 - 2] = Barrier.BRICK;
		mapData[row - 4][col / 2 - 3] = Barrier.BRICK;

		mapData[row - 3][col / 2 + 1] = Barrier.BRICK;// ����
		mapData[row - 3][col / 2 + 2] = Barrier.BRICK;
		mapData[row - 4][col / 2 + 1] = Barrier.BRICK;
		mapData[row - 4][col / 2 + 2] = Barrier.BRICK;

		mapData[row - 3][col / 2 - 1] = Barrier.BRICK;// ��
		mapData[row - 3][col / 2] = Barrier.BRICK;
		mapData[row - 4][col / 2 - 1] = Barrier.BRICK;
		mapData[row - 4][col / 2] = Barrier.BRICK;
	}

	/**
	 * ������һ�صķ���
	 */
	public void goToNextMission() {
		if (missionNum >= this.MAP_SP.length) {
			// ͨ�صĴ���
			System.out
					.println("congartulations! All missions are completed!!!");
			return;
		}
		missionNum++;
		mapData = copyMapData(this.MAP_SP[missionNum - 1]);
		// ����������
		MySurfaceView.countTankDestoryed = 0;
		// Ӣ��̹�˻ص�ԭ����λ��
		MySurfaceView.hero.backHome();
		// ���������
		MySurfaceView.map.reward = null;
	}

	/**
	 * �õ��ؿ���
	 * 
	 * @return
	 */
	public int getMissionNum() {
		return missionNum;
	}

	/**
	 * ���ùؿ���
	 * 
	 * @param missionNum
	 */
	public void setMissionNum(int missionNum) {
		this.missionNum = missionNum;
	}

}

package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ��������
 * 
 * @author timbo
 * @version v1.0
 */
public abstract class Reward {
	public static final int STAR = 0;
	public static final int BOMB = 1;
	public static final int LIFE = 2;
	public static final int SHOVEL = 3;
	public static final int PROTECTOR = 4;
	public static final int TIMER = 5;

	/**
	 * �������������(��������ʱҪ��ʱ�޸�)
	 */
	public static final int REWARD_KIND_COUNT = 6;
	int x;
	int y;
	Bitmap bitmap;

	/**
	 * ���캯�� -> ������ɽ������λ��
	 */
	public Reward() {
		x = (int) (Math.random() * (Constant.GAME_VIEW_WIDTH - Constant.REWARD_SIZE))
				+ Constant.GAME_VIEW_X;
		y = (int) (Math.random() * (Constant.GAME_VIEW_HEIGHT - Constant.REWARD_SIZE))
				+ Constant.GAME_VIEW_Y;
	}

	/**
	 * ���ƽ�����
	 * 
	 * @param canvas
	 *            ����
	 * @param paint
	 *            ����
	 */
	abstract void drawSelf(Canvas canvas, Paint paint);

	/**
	 * �������һ��������ķ���
	 * 
	 * @return
	 */
	static Reward generateAReward() {
		Reward result = null;
		int i = (int) (Math.random() * Reward.REWARD_KIND_COUNT);
		switch (i) {
		case Reward.STAR:
			result = new Star(MySurfaceView.starBitmap);
			break;
		case Reward.BOMB:
			result = new Bomb(MySurfaceView.bombBitmap);
			break;
		case Reward.LIFE:
			result = new Life(MySurfaceView.lifeBitmap);
			break;
		case Reward.SHOVEL:
			result = new Shovel(MySurfaceView.shovelBitmap);
			break;
		case Reward.PROTECTOR:
			result = new Protector(MySurfaceView.protectorBitmap);
			break;
		case Reward.TIMER:
			result = new Timer(MySurfaceView.timerBitmap);
			break;
		}
		return result;
	}
}

package com.timbo.tankwar;

/**
 * ��ɫ��ǿ̹����
 * @author timbo
 * @version v1.0
 */
public class RedTankStrong extends TankStrong {
	public RedTankStrong(int direction, int x, int y) {
		super(direction, x, y);
		this.tanki = MySurfaceView.tankRedi3;
	}

	@Override
	void explode() {
		super.explode();
		// ��ը�����������
		MySurfaceView.map.reward = Reward.generateAReward();
	}
}

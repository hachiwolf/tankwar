package com.timbo.tankwar;
/**
 * ��ɫ�����з�̹����
 * @author timbo
 * @version v1.0
 */
public class RedTankNormal extends TankNormal {
	public RedTankNormal(int direction, int x, int y) {
		super(direction, x, y);
		this.tanki = MySurfaceView.tankRedi1;
	}

	@Override
	void explode() {
		super.explode();
		// ��ը�����������
		MySurfaceView.map.reward = Reward.generateAReward();
	}
}
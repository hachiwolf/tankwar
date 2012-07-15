package com.timbo.tankwar;

/**
 * 红色加强坦克类
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
		// 爆炸后产生奖励物
		MySurfaceView.map.reward = Reward.generateAReward();
	}
}

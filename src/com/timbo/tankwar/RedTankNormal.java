package com.timbo.tankwar;
/**
 * 红色正常敌方坦克类
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
		// 爆炸后产生奖励物
		MySurfaceView.map.reward = Reward.generateAReward();
	}
}
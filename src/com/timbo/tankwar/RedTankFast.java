package com.timbo.tankwar;
/**
 * 红色快速坦克类
 * @author timbo
 *
 */
public class RedTankFast extends TankFast
{
	public RedTankFast(int direction, int x,int y) 
	{
		super(direction, x, y);
		this.tanki=MySurfaceView.tankRedi2;
	}
	
	@Override
	void explode()
	{
		super.explode();
		//爆炸后产生奖励物
		MySurfaceView.map.reward=Reward.generateAReward();		
	}
}

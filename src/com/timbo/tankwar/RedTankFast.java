package com.timbo.tankwar;
/**
 * ��ɫ����̹����
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
		//��ը�����������
		MySurfaceView.map.reward=Reward.generateAReward();		
	}
}

package com.timbo.tankwar;
/**
 * �����з�̹����
 * @author timbo
 * @version v1.0
 */
public class TankNormal extends Tank
{
	public TankNormal(int direction, int x, int y)
	{
		super(direction, x, y);
		this.tanki=MySurfaceView.tanki1;
		this.span=2;
		this.life=1;
	}
	@Override
	void explode()
	{
		super.explode();
		MySurfaceView.score+=1;
	}
}

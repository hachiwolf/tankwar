package com.timbo.tankwar;
/**
 * 加强坦克基类
 * @author timbo
 *
 */
public class TankStrong extends Tank
{
	public TankStrong(int direction, int x, int y)
	{
		super(direction, x, y);
		this.tanki=MySurfaceView.tanki3;
		this.span=2;
		this.life=3;
	}
	@Override
	void explode()
	{
		super.explode();
		MySurfaceView.score+=3;
	}
}

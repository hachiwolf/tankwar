package com.timbo.tankwar;


/**
 * 加强速度子弹类（英雄吃了一个星星时的状态）
 * @author timbo
 * @version v1.0
 */
public class HeroBulletFast extends HeroBullet
{
	public HeroBulletFast(int direction, int x, int y)
	{
		super(MySurfaceView.heroBullet,direction, x, y);
		this.span=Constant.HERO_BULLET_SPAN_FAST;
	}
}
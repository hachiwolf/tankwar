package com.timbo.tankwar;

/**
 * 英雄坦克正常子弹类(没吃星星的状态)
 * @author timbo
 * @version v1.0
 */
public class HeroBulletNormal extends HeroBullet
{

	public HeroBulletNormal(int direction, int x, int y)
	{
		super(MySurfaceView.heroBullet,direction, x, y);
		this.span=Constant.HERO_BULLET_INIT_SPAN;
	}

}

package com.timbo.tankwar;


/**
 * ��ǿ�ٶ��ӵ��ࣨӢ�۳���һ������ʱ��״̬��
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
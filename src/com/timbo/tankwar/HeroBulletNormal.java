package com.timbo.tankwar;

/**
 * Ӣ��̹�������ӵ���(û�����ǵ�״̬)
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

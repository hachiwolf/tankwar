package com.timbo.tankwar;



/**
 * ���������߳���
 * @author timbo
 * @version v1.0
 */
public class BuildHomeThread extends Thread
{
	@Override
	public void run()
	{
		MySurfaceView.map.buildHomeWithStone();
		try
		{
			Thread.sleep(Constant.TIME_BACK_TO_BRICK_FROM_STONE);//һ��ʱ���ָ�שǽ
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		MySurfaceView.map.buildHomeWithBrick();
	}
}

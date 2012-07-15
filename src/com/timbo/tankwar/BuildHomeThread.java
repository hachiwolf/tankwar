package com.timbo.tankwar;



/**
 * 建造老窝线程类
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
			Thread.sleep(Constant.TIME_BACK_TO_BRICK_FROM_STONE);//一定时间后恢复砖墙
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		MySurfaceView.map.buildHomeWithBrick();
	}
}

package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * 敌方坦克改变方向线程类
 * @author timbo
 *
 */
public class TankChangeDirectionThread extends Thread {
	public void run() {
		while (MySurfaceView.TankChangeDirectionFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// 获取已存在坦克存放列表

				for (Tank tank : alTank)// 循环每一个坦克
				{
					tank.changeDirection();
				}
				Thread.sleep(1000);// 每隔一秒钟检测一次
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

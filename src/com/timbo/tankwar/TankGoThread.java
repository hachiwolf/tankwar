package com.timbo.tankwar;

import java.util.ArrayList;


/**
 * 敌方坦克随机运行类
 * @author timbo
 *
 */
public class TankGoThread extends Thread {
	public void run() {
		while (MySurfaceView.TankGoFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// 获得已有坦克存放列表
				for (Tank tank : alTank)// 循环控制各个坦克的运动
				{
					tank.go();
				}
				Thread.sleep(100);// 每个100毫秒坦克运动一次
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

package com.timbo.tankwar;

import java.util.ArrayList;


/**
 * 敌方坦克发送子弹类
 * @author timbo
 *
 */
public class TankSendBulletThread extends Thread {
	@Override
	public void run() {
		while (MySurfaceView.tankSendBulletFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// 获得敌坦克列表
				for (Tank t : alTank) {
					if (Math.random() < Constant.TANK_SEND_BULLET_POSSIBILITY
							&& MySurfaceView.alBullet.size() < Constant.TANK_BULLET_MAX_NUM) {
						Bullet b = t.sendBullet();
						MySurfaceView.alBullet.add(b);
					}
				}

				Thread.sleep(1000);// 每隔一秒钟发射一次
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

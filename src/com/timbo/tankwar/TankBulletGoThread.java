package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * 敌方坦克子弹运行线程类
 * @author timbo
 *
 */
public class TankBulletGoThread extends Thread {
	public void run() {
		while (MySurfaceView.tankBulletGoFlag) {
			try {
				ArrayList<Bullet> alBullet = new ArrayList<Bullet>(
						MySurfaceView.alBullet);// 复制敌子弹列表
				for (Bullet b : alBullet) {
					b.go();
				}

				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

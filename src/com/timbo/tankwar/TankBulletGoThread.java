package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * �з�̹���ӵ������߳���
 * @author timbo
 *
 */
public class TankBulletGoThread extends Thread {
	public void run() {
		while (MySurfaceView.tankBulletGoFlag) {
			try {
				ArrayList<Bullet> alBullet = new ArrayList<Bullet>(
						MySurfaceView.alBullet);// ���Ƶ��ӵ��б�
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

package com.timbo.tankwar;


/**
 * Ӣ��̹�˷����ӵ��߳���
 * @author timbo
 *
 */
public class HeroSendBulletThread extends Thread {
	@Override
	public void run() {
		while (MySurfaceView.heroSendBulletFlag) {
			// Ӣ��̹�˷����ӵ�
			if (MySurfaceView.alHeroBullet.size() < MySurfaceView.hero.heroBulletMaxNum) {
				HeroBullet hb = MySurfaceView.hero.sendBullet();
				MySurfaceView.alHeroBullet.add(hb);
			}
		}
	}
}

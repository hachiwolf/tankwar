package com.timbo.tankwar;


/**
 * 英雄坦克发送子弹线程类
 * @author timbo
 *
 */
public class HeroSendBulletThread extends Thread {
	@Override
	public void run() {
		while (MySurfaceView.heroSendBulletFlag) {
			// 英雄坦克发射子弹
			if (MySurfaceView.alHeroBullet.size() < MySurfaceView.hero.heroBulletMaxNum) {
				HeroBullet hb = MySurfaceView.hero.sendBullet();
				MySurfaceView.alHeroBullet.add(hb);
			}
		}
	}
}

package com.timbo.tankwar;


/**
 * Ӣ�������߳���
 * @author timbo
 * @version v1.0
 */
public class HeroGoThread extends Thread {
	public void run() {
		while (MySurfaceView.heroGoFlag) {
			if (!MySurfaceView.gameOverFlag) {
				MySurfaceView.hero.go();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

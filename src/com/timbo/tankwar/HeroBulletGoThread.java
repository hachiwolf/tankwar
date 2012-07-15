package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * 英雄子弹运行线程类
 * @author timbo
 * @version v1.0
 */
public class HeroBulletGoThread extends Thread {
	public void run() {
		while (MySurfaceView.heroBulletGoFlag) {
			try {
				ArrayList<HeroBullet> alHeroBullet = new ArrayList<HeroBullet>(
						MySurfaceView.alHeroBullet);// 复制英雄子弹列表

				for (HeroBullet hb : alHeroBullet)// 循环扫描英雄子弹列表
				{
					hb.go();
					Thread.sleep(10);// 每10毫秒检测一次
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

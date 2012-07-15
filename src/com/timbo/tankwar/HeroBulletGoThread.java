package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * Ӣ���ӵ������߳���
 * @author timbo
 * @version v1.0
 */
public class HeroBulletGoThread extends Thread {
	public void run() {
		while (MySurfaceView.heroBulletGoFlag) {
			try {
				ArrayList<HeroBullet> alHeroBullet = new ArrayList<HeroBullet>(
						MySurfaceView.alHeroBullet);// ����Ӣ���ӵ��б�

				for (HeroBullet hb : alHeroBullet)// ѭ��ɨ��Ӣ���ӵ��б�
				{
					hb.go();
					Thread.sleep(10);// ÿ10������һ��
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

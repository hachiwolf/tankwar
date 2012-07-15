package com.timbo.tankwar;

import java.util.ArrayList;


/**
 * �з�̹�˷����ӵ���
 * @author timbo
 *
 */
public class TankSendBulletThread extends Thread {
	@Override
	public void run() {
		while (MySurfaceView.tankSendBulletFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// ��õ�̹���б�
				for (Tank t : alTank) {
					if (Math.random() < Constant.TANK_SEND_BULLET_POSSIBILITY
							&& MySurfaceView.alBullet.size() < Constant.TANK_BULLET_MAX_NUM) {
						Bullet b = t.sendBullet();
						MySurfaceView.alBullet.add(b);
					}
				}

				Thread.sleep(1000);// ÿ��һ���ӷ���һ��
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

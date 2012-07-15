package com.timbo.tankwar;


/**
 * �з�̹�˶�ʱ�߳���
 * @author timbo
 *
 */
public class StopTankForAMomentThread extends Thread {
	@Override
	public void run() {
		MySurfaceView.TankChangeDirectionFlag = false;
		MySurfaceView.TankGoFlag = false;
		MySurfaceView.tankSendBulletFlag = false;
		try {
			Thread.sleep(Constant.TIME_TANK_STOP);// һ��ʱ���̹�������ָ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		MySurfaceView.TankChangeDirectionFlag = true;
		MySurfaceView.TankGoFlag = true;
		MySurfaceView.tankSendBulletFlag = true;

		MySurfaceView.go = new TankGoThread();
		MySurfaceView.changeDirection = new TankChangeDirectionThread();
		MySurfaceView.tankSendBullet = new TankSendBulletThread();

		MySurfaceView.go.start();
		MySurfaceView.changeDirection.start();
		MySurfaceView.tankSendBullet.start();
	}
}

package com.timbo.tankwar;

import java.util.ArrayList;

/**
 * �з�̹�˸ı䷽���߳���
 * @author timbo
 *
 */
public class TankChangeDirectionThread extends Thread {
	public void run() {
		while (MySurfaceView.TankChangeDirectionFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// ��ȡ�Ѵ���̹�˴���б�

				for (Tank tank : alTank)// ѭ��ÿһ��̹��
				{
					tank.changeDirection();
				}
				Thread.sleep(1000);// ÿ��һ���Ӽ��һ��
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

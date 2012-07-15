package com.timbo.tankwar;

import java.util.ArrayList;


/**
 * �з�̹�����������
 * @author timbo
 *
 */
public class TankGoThread extends Thread {
	public void run() {
		while (MySurfaceView.TankGoFlag) {
			try {
				ArrayList<Tank> alTank = new ArrayList<Tank>(
						MySurfaceView.alTank);// �������̹�˴���б�
				for (Tank tank : alTank)// ѭ�����Ƹ���̹�˵��˶�
				{
					tank.go();
				}
				Thread.sleep(100);// ÿ��100����̹���˶�һ��
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

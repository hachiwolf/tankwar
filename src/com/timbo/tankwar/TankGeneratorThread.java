package com.timbo.tankwar;

import static com.timbo.tankwar.Constant.*;

/**
 * �з�̹��������
 * @author timbo
 *
 */
public class TankGeneratorThread extends Thread {
	public void run() {
		while (MySurfaceView.TankGeneratorFlag) {
			if (this.canGenerateATank()) {
				try {
					int direction = (int) (Math.random() * 4);// ����̹�˸����������
					// ����̹�˸������λ��
					int x = Constant.GAME_VIEW_X;
					int y = Constant.GAME_VIEW_Y;
					int i = (int) (Math.random() * 3);
					switch (i)// ������ɵ�λ�ò���̫���ߣ����������ײ��������
					{
					case 0:
						x += 1;
						y += 1;
						break;
					case 1:
						x += GAME_VIEW_WIDTH - Constant.TANK_SIZE - 1;
						y += 1;
						break;
					case 2:
						x += (GAME_VIEW_WIDTH - Constant.TANK_SIZE) / 2;
						y += 1;
						break;
					}
					Tank tank = null;
					i = (int) (Math.random() * 6);
					switch (i) {
					case 0:
						tank = new TankNormal(direction, x, y);// ����̹�˶���1
						break;
					case 1:
						tank = new TankFast(direction, x, y);// ����̹�˶���2
						break;
					case 2:
						tank = new TankStrong(direction, x, y);// ����̹�˶���3
						break;
					case 3:
						tank = new RedTankNormal(direction, x, y);// ������̹�˶���1
						break;
					case 4:
						tank = new RedTankFast(direction, x, y);// ������̹�˶���2
						break;
					case 5:
						tank = new RedTankStrong(direction, x, y);// ������̹�˶���3
						break;
					}
					if (tank.canGo(x, y))// ����̹�˵�λ�ú����ټ���̹���б�
					{
						MySurfaceView.alTank.add(tank);// ������̹����ӵ�̹���б�
					}

					Thread.sleep(5000);// ÿ������������һ���µ�̹��
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ����Ƿ���Ҫ����̹��
	 * @return true ������false ������
	 */
	private boolean canGenerateATank() {
		if (!MySurfaceView.isCurrentMissionCompleted()
				&& // ��ǰ����û�����
				MySurfaceView.countTankDestoryed
						+ MySurfaceView.alTank.size() < Constant.TANK_TOTAL_NUM
				&& MySurfaceView.alTank.size() < Constant.TANK_MAX_NUM_IN_GAME_VIEW) {
			return true;
		}
		return false;

	}
}

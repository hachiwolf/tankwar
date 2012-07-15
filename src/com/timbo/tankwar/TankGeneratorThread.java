package com.timbo.tankwar;

import static com.timbo.tankwar.Constant.*;

/**
 * 敌方坦克生产类
 * @author timbo
 *
 */
public class TankGeneratorThread extends Thread {
	public void run() {
		while (MySurfaceView.TankGeneratorFlag) {
			if (this.canGenerateATank()) {
				try {
					int direction = (int) (Math.random() * 4);// 生成坦克赋予随机方向
					// 生成坦克赋予随机位置
					int x = Constant.GAME_VIEW_X;
					int y = Constant.GAME_VIEW_Y;
					int i = (int) (Math.random() * 3);
					switch (i)// 随机生成的位置不能太靠边，否则会因碰撞检测而卡死
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
						tank = new TankNormal(direction, x, y);// 创建坦克对象1
						break;
					case 1:
						tank = new TankFast(direction, x, y);// 创建坦克对象2
						break;
					case 2:
						tank = new TankStrong(direction, x, y);// 创建坦克对象3
						break;
					case 3:
						tank = new RedTankNormal(direction, x, y);// 创建红坦克对象1
						break;
					case 4:
						tank = new RedTankFast(direction, x, y);// 创建红坦克对象2
						break;
					case 5:
						tank = new RedTankStrong(direction, x, y);// 创建红坦克对象3
						break;
					}
					if (tank.canGo(x, y))// 生成坦克的位置合理，再加入坦克列表
					{
						MySurfaceView.alTank.add(tank);// 将生成坦克添加到坦克列表
					}

					Thread.sleep(5000);// 每隔五秒钟生成一个新的坦克
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 检测是否需要生产坦克
	 * @return true 生产，false 不生产
	 */
	private boolean canGenerateATank() {
		if (!MySurfaceView.isCurrentMissionCompleted()
				&& // 当前任务没有完成
				MySurfaceView.countTankDestoryed
						+ MySurfaceView.alTank.size() < Constant.TANK_TOTAL_NUM
				&& MySurfaceView.alTank.size() < Constant.TANK_MAX_NUM_IN_GAME_VIEW) {
			return true;
		}
		return false;

	}
}

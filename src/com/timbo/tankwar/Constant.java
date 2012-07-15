package com.timbo.tankwar;


/**
 * 常量数据类
 * 
 * @author timbo
 * @version v1.0
 */
public class Constant {
	/**
	 * 左上顶点X轴坐标
	 */
	public static int LEFT_TOP_X = 0;
	/**
	 * 左上顶点Y轴坐标
	 */
	public static int LEFT_TOP_Y = 0;
	/**
	 * 屏幕高度
	 */
	public static int SCREEN_HEIGHT;
	/**
	 * 屏幕宽度
	 */
	public static int SCREEN_WIDTH;
	/**
	 * 屏幕上边留白宽度
	 */
	public static int UP_MARGIN = 60;
	/**
	 * 屏幕上边条的宽度
	 */
	public static int UP_BAR = 5;
	/**
	 * 屏幕右边留白宽度
	 */
	public static int RIGHT_MARGIN = 60;
	/**
	 * 屏幕右边条的宽度
	 */
	public static int RIGHT_BAR = 5;

	/**
	 * 游戏界面X坐标
	 */
	public static int GAME_VIEW_X;
	/**
	 * 游戏界面Y坐标
	 */
	public static int GAME_VIEW_Y;
	/**
	 * 游戏界面宽度
	 */
	public static int GAME_VIEW_WIDTH;
	/**
	 * 游戏界面高度
	 */
	public static int GAME_VIEW_HEIGHT;
	/**
	 * 敌方坦克发子弹的可能性,0.8难度适中
	 */
	public static final float TANK_SEND_BULLET_POSSIBILITY = 0.8f;
	/**
	 * 敌方坦克改变运动方向的可能性
	 */
	public static final float TANK_CHANGE_DIRECTION_POSSIBILITY = 0.4f;
	/**
	 * 敌方坦克如果改变运动方向，向下的可能性(1-3/n)的n值,值越大，向下走的可能性越大,5或6较合适
	 */
	public static final int VALUE_TANK_GO_DOWN = 6;
	/**
	 * 英雄初始总命数
	 */
	public static final int HERO_LIFE = 3;
	/**
	 * 英雄行进速度
	 */
	public static final int HERO_SPAN = 6;
	/**
	 * 游戏界面中敌方坦克最大数量
	 */
	public static final int TANK_MAX_NUM_IN_GAME_VIEW = 4;
	/**
	 * 每一关卡中敌方坦克总数量
	 */
	public static final int TANK_TOTAL_NUM = 10;
	/**
	 * 敌方子弹最大数量
	 */
	public static final int TANK_BULLET_MAX_NUM = 4;
	/**
	 * 敌方子弹速度
	 */
	public static final int TANK_BULLET_SPAN = 3;
	/**
	 * 英雄子弹初始速度
	 */
	public static final int HERO_BULLET_INIT_SPAN = 1;
	/**
	 * 英雄坦克吃一个星星后,子弹速度
	 */
	public static final int HERO_BULLET_SPAN_FAST = 4;
	/**
	 * 英雄子弹初始最大数量
	 */
	public static final int HERO_BULLET_INIT_MAX_NUM = 1;
	/**
	 * 英雄坦克吃两个星星后,子弹最大数量
	 */
	public static final int HERO_BULLET_MAX_NUM_MORE = 2;
	/**
	 * 子弹大小
	 */
	public static final int BULLET_SIZE = 8;
	/**
	 * 坦克大小
	 */
	public static final int TANK_SIZE = 24;
	/**
	 * 坦克大小修正值，用于碰撞检测,值越大，坦克越容易通过障碍
	 */
	public static final int TANK_SIZE_REVISE = 3;
	/**
	 * 障碍物尺寸
	 */
	public static final int BARRIER_SIZE = 28 / 2;
	/**
	 * 老窝尺寸
	 */
	public static final int HOME_SIZE = BARRIER_SIZE * 2;
	/**
	 * 奖励物尺寸
	 */
	public static final int REWARD_SIZE = BARRIER_SIZE * 2;
	/**
	 * 吃铁锹后，恢复砖墙的时间
	 */
	public static final int TIME_BACK_TO_BRICK_FROM_STONE = 15000;
	/**
	 * 吃定时器后，敌方坦克定住的时间
	 */
	public static final int TIME_TANK_STOP = 15000;
	/**
	 * 吃保护器后，英雄坦克受保护的时间
	 */
	public static final int TIME_WEARING_PROTECTOR = 15000;
	/**
	 * 障碍物数组列数
	 */
	public static int BARRIER_ARRAY_WIDTH; // RIGHT_MARGIN=60时，列数为30，行数为22，
	/**
	 * 障碍物数组行数
	 */
	public static int BARRIER_ARRAY_HEIGHT; // 在程序中没有实际用到，用于开发时计算地图数组的行列数

	// =================================================数字参数============================================//

	/**
	 * 第一条信息的离左边的距离
	 */
	public static int FIRST_NUMBER_WIDTH = 10;
	/**
	 * 每一个数字占屏幕的宽度
	 */
	public static int NUMBER_WIDTH = 12;
	/**
	 * 每一个数字占屏幕的宽度
	 */
	public static int NUMBER_TOTAL_WIDTH = 58;
	/**
	 * 数字占屏幕的高度
	 */
	public static int NUMBER_HEIGHT = 30;
	// =================================================汉字参数============================================//
	/**
	 * 第一条信息的离左边的距离
	 */
	public static int FIRST_HANZI_WIDTH;
	/**
	 * 汉字占屏幕的宽度
	 */
	public static int HANZI_WIDTH;
	/**
	 * 汉字占屏幕的高度
	 */
	public static int HANZI_HEIGHT;
	/**
	 * 第一条信息的高度
	 */
	public static int FIRST_MESSAGE_HEIGHT;

	// ======================================标记区域值========================================//
	// ========================================begin===========================================//
	/**
	 * 虚拟键盘总尺寸 (宽度)
	 */
	public static float BUTTON_TOTAL_WIDTH;
	/**
	 * 虚拟键盘总尺寸 (高度)
	 */
	public static float BUTTON_TOTAL_HEIGHT;
	/**
	 * 虚拟键盘区域的左上X坐标
	 */
	public static float BUTTON_AREA_X;
	/**
	 * 虚拟键盘区域的左上Y坐标
	 */
	public static float BUTTON_AREA_Y;
	/**
	 * 虚拟键盘尺寸 (宽度)
	 */
	public static float BUTTON_WIDTH;
	/**
	 * 虚拟键盘尺寸 (高度)
	 */
	public static float BUTTON_HEIGHT;
	/**
	 * 剩余尺寸的一半 (高度)
	 */
	public static float OTHER_WIDTH;
	/**
	 * 剩余尺寸的一半 (宽度)
	 */
	public static float OTHER_HEIGHT;
	/**
	 * 四个按钮的上点X坐标
	 */
	public static float UP_X;
	/**
	 * 四个按钮的上点Y坐标
	 */
	public static float UP_Y;
	/**
	 * 四个按钮的下点X坐标
	 */
	public static float DOWN_X;
	/**
	 * 四个按钮的下点Y坐标
	 */
	public static float DOWN_Y;
	/**
	 * 四个按钮的左点X坐标
	 */
	public static float LEFT_X;
	/**
	 * 四个按钮的左点Y坐标
	 */
	public static float LEFT_Y;
	/**
	 * 四个按钮的右点X坐标
	 */
	public static float RIGHT_X;
	/**
	 * 四个按钮的右点Y坐标
	 */
	public static float RIGHT_Y;
	/**
	 * 发射子弹区域的尺寸 (宽度)
	 */
	public static float FIRE_BTN_WIDTH;
	/**
	 * 发射子弹区域的尺寸 (高度)
	 */
	public static float FIRE_BTN_HEIGHT;
	/**
	 * 发射子弹区域的左上点X坐标
	 */
	public static float FIRE_BTN_X;
	/**
	 * 发射子弹区域的左上点Y坐标
	 */
	public static float FIRE_BTN_Y;

	// ======================================标记区域值========================================//
	// =========================================end============================================//

	// ======================================图片值===========================================//
	// =======================================begin===========================================//

	/**
	 * 虚拟键盘的左上X坐标
	 */
	public static float BUTTON_X;
	/**
	 * 虚拟键盘的左上Y坐标
	 */
	public static float BUTTON_Y;
	/**
	 * 红点坐标X坐标
	 */
	public static float RED_DOT_CENTER_X;
	/**
	 * 红点坐标Y坐标
	 */
	public static float RED_DOT_CENTER_Y;
	/**
	 * 发射图片的X坐标
	 */
	public static float FIR_MAP_X;
	/**
	 * 发射图片的Y坐标
	 */
	public static float FIR_MAP_Y;

	// ======================================图片值===========================================//
	// ========================================end============================================//

	/**
	 * 初始化常量的方法
	 */
	public static void initConst() {
		SCREEN_HEIGHT = ConstantHP.SCREEN_HEIGHT;
		SCREEN_WIDTH = ConstantHP.SCREEN_WIDTH;
		GAME_VIEW_X = ConstantHP.GAME_VIEW_X;
		GAME_VIEW_Y = ConstantHP.GAME_VIEW_Y;
		GAME_VIEW_WIDTH = ConstantHP.GAME_VIEW_WIDTH;
		GAME_VIEW_HEIGHT = ConstantHP.GAME_VIEW_HEIGHT;
		RIGHT_MARGIN = ConstantHP.RIGHT_MARGIN;// 屏幕右边留白宽度
		RIGHT_BAR = ConstantHP.RIGHT_BAR;// 屏幕右边条的宽度

		NUMBER_WIDTH = ConstantHP.NUMBER_WIDTH;// 每一个数字占屏幕的宽度
		FIRST_MESSAGE_HEIGHT = ConstantHP.FIRST_MESSAGE_HEIGHT;// 第一条信息的高度
		HANZI_HEIGHT = ConstantHP.HANZI_HEIGHT;// 汉字占屏幕的高度
		NUMBER_HEIGHT = ConstantHP.NUMBER_HEIGHT;// 数字占屏幕的高度

		BUTTON_TOTAL_WIDTH = ConstantHP.BUTTON_TOTAL_WIDTH;
		BUTTON_TOTAL_HEIGHT = ConstantHP.BUTTON_TOTAL_HEIGHT;
		BUTTON_AREA_X = ConstantHP.BUTTON_AREA_X;
		BUTTON_AREA_Y = ConstantHP.BUTTON_AREA_Y;
		BUTTON_WIDTH = ConstantHP.BUTTON_WIDTH;
		BUTTON_HEIGHT = ConstantHP.BUTTON_HEIGHT;
		OTHER_WIDTH = ConstantHP.OTHER_WIDTH;
		OTHER_HEIGHT = ConstantHP.OTHER_HEIGHT;
		UP_X = ConstantHP.UP_X;
		UP_Y = ConstantHP.UP_Y;
		DOWN_X = ConstantHP.DOWN_X;
		DOWN_Y = ConstantHP.DOWN_Y;
		LEFT_X = ConstantHP.LEFT_X;
		LEFT_Y = ConstantHP.LEFT_Y;
		RIGHT_X = ConstantHP.RIGHT_X;
		RIGHT_Y = ConstantHP.RIGHT_Y;
		FIRE_BTN_WIDTH = ConstantHP.FIRE_BTN_WIDTH;
		FIRE_BTN_HEIGHT = ConstantHP.FIRE_BTN_HEIGHT;
		GAME_VIEW_X = ConstantHP.GAME_VIEW_X;
		FIRE_BTN_Y = ConstantHP.FIRE_BTN_Y;

		BUTTON_X = ConstantHP.BUTTON_X;
		BUTTON_Y = ConstantHP.BUTTON_Y;
		RED_DOT_CENTER_X = ConstantHP.RED_DOT_CENTER_X;
		RED_DOT_CENTER_Y = ConstantHP.RED_DOT_CENTER_Y;
		FIR_MAP_X = ConstantHP.FIR_MAP_X;
		FIR_MAP_Y = ConstantHP.FIR_MAP_Y;
		BARRIER_ARRAY_WIDTH = GAME_VIEW_WIDTH / BARRIER_SIZE; // 障碍物数组列数
																// //RIGHT_MARGIN=60时，列数为30，行数为22，
		BARRIER_ARRAY_HEIGHT = GAME_VIEW_HEIGHT / BARRIER_SIZE; // 障碍物数组行数
																// //在程序中没有实际用到，用于开发时计算地图数组的行列数
		System.out.println("地图数组的行列数：" + Constant.BARRIER_ARRAY_WIDTH + ","
				+ Constant.BARRIER_ARRAY_HEIGHT);
	}

	/**
	 * 判定一个矩形的四个顶点之一是否在另一个矩形内
	 * 
	 * @param xLeftTop1
	 *            左上点1 X值
	 * @param yLeftTop1
	 *            左上点1 Y值
	 * @param length1
	 *            左上点1长度
	 * @param width1
	 *            左上点1宽度
	 * @param xLeftTop2
	 *            左上点1 X值
	 * @param yLeftTop2
	 *            左上点1 Y值
	 * @param length2
	 *            左上点1长度
	 * @param width2左上点1宽度
	 * 
	 * @return true 包含在内，false 不包含在内
	 */
	public static boolean oneIsInAnother(int xLeftTop1, int yLeftTop1,
			int length1, int width1, int xLeftTop2, int yLeftTop2, int length2,
			int width2) {
		if (pointIsInRect(xLeftTop1, yLeftTop1, xLeftTop2, yLeftTop2, length2,
				width2) || // 左上顶点
				pointIsInRect(xLeftTop1 + length1, yLeftTop1, xLeftTop2,
						yLeftTop2, length2, width2) || // 右上顶点
				pointIsInRect(xLeftTop1, yLeftTop1 + width1, xLeftTop2,
						yLeftTop2, length2, width2) || // 左下顶点
				pointIsInRect(xLeftTop1 + length1, yLeftTop1 + width1,
						xLeftTop2, yLeftTop2, length2, width2) || // 右下顶点

				pointIsInRect(xLeftTop2, yLeftTop2, xLeftTop1, yLeftTop1,
						length1, width1) || // 左上顶点
				pointIsInRect(xLeftTop2 + length2, yLeftTop2, xLeftTop1,
						yLeftTop1, length1, width1) || // 右上顶点
				pointIsInRect(xLeftTop2, yLeftTop2 + width2, xLeftTop1,
						yLeftTop1, length1, width1) || // 左下顶点
				pointIsInRect(xLeftTop2 + length2, yLeftTop2 + width2,
						xLeftTop1, yLeftTop1, length1, width1) // 右下顶点
		) {
			return true;
		}
		return false;
	}

	/**
	 * 一个点是否在矩形内（包括边界）
	 * 
	 * @param pointx
	 *            点X值(int)
	 * @param pointy
	 *            点Y值(int)
	 * @param xLeftTop
	 *            矩形左上点X值(int)
	 * @param yLeftTop
	 *            矩形左上点Y值(int)
	 * @param length
	 *            矩形长度(int)
	 * @param width
	 *            矩形宽度(int)
	 * @return true 在矩形内，false 不在矩形内
	 */
	public static boolean pointIsInRect(int pointx, int pointy, int xLeftTop,
			int yLeftTop, int length, int width) {
		if (pointx >= xLeftTop && pointx <= xLeftTop + length
				&& pointy >= yLeftTop && pointy <= yLeftTop + width) {
			return true;
		}
		return false;
	}

	/**
	 * 一个点是否在矩形内（包括边界）
	 * 
	 * @param pointx
	 *            点X值(float)
	 * @param pointy
	 *            点Y值(float)
	 * @param xLeftTop
	 *            矩形左上点X值(float)
	 * @param yLeftTop
	 *            矩形左上点Y值(float)
	 * @param length
	 *            矩形长度(float)
	 * @param width
	 *            矩形宽度(float)
	 * @return true 在矩形内，false 不在矩形内
	 */
	public static boolean pointIsInRect(float pointx, float pointy,
			float xLeftTop, float yLeftTop, float length, float width) {
		if (pointx >= xLeftTop && pointx <= xLeftTop + length
				&& pointy >= yLeftTop && pointy <= yLeftTop + width) {
			return true;
		}
		return false;
	}

	/**
	 * 检测敌方坦克是否在游戏界面中的方法
	 * 
	 * @param xTemp
	 *            X坐标
	 * @param yTemp
	 *            Y坐标
	 * @return true 在界面内，false 不在界面内
	 */
	public static boolean isTankInGameView(int xTemp, int yTemp) {
		xTemp = xTemp + Constant.TANK_SIZE_REVISE;
		yTemp = yTemp + Constant.TANK_SIZE_REVISE;
		int tankSizeRevised = Constant.TANK_SIZE - 2
				* Constant.TANK_SIZE_REVISE - 2;// 两个方法修正值不一样，所以要分开写
		if (yTemp <= Constant.GAME_VIEW_Y
				|| yTemp > Constant.GAME_VIEW_Y + GAME_VIEW_HEIGHT
						- tankSizeRevised
				|| xTemp <= Constant.GAME_VIEW_X
				|| xTemp >= Constant.GAME_VIEW_X + GAME_VIEW_WIDTH
						- tankSizeRevised) {
			return false;
		}
		return true;
	}

	/**
	 * 检测英雄坦克是否在游戏界面中的方法
	 * 
	 * @param xTemp
	 *            X坐标
	 * @param yTemp
	 *            Y坐标
	 * @return true 在界面内，false 不在界面内
	 */
	public static boolean isHeroInGameView(int xTemp, int yTemp) {
		xTemp = xTemp + Constant.TANK_SIZE_REVISE;
		yTemp = yTemp + Constant.TANK_SIZE_REVISE;
		int tankSizeRevised = Constant.TANK_SIZE - 2
				* Constant.TANK_SIZE_REVISE - 6;// 两个方法修正值不一样，所以要分开写
		if (yTemp <= Constant.GAME_VIEW_Y
				|| yTemp > Constant.GAME_VIEW_Y + GAME_VIEW_HEIGHT
						- tankSizeRevised
				|| xTemp <= Constant.GAME_VIEW_X
				|| xTemp >= Constant.GAME_VIEW_X + GAME_VIEW_WIDTH
						- tankSizeRevised) {
			return false;
		}
		return true;
	}

	/**
	 * 检测子弹（包括英雄子弹）是否在游戏界面中的方法
	 * 
	 * @param xTemp
	 *            X坐标
	 * @param yTemp
	 *            Y坐标
	 * @return true 在界面内，false 不在界面内
	 */
	public static boolean isBulletInGameView(int xTemp, int yTemp) {
		if (yTemp <= Constant.GAME_VIEW_Y
				|| yTemp > Constant.GAME_VIEW_Y + GAME_VIEW_HEIGHT
				|| xTemp <= Constant.GAME_VIEW_X
				|| xTemp >= Constant.GAME_VIEW_X + GAME_VIEW_WIDTH) {
			return false;
		}
		return true;
	}
}

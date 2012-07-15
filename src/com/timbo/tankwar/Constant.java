package com.timbo.tankwar;


/**
 * ����������
 * 
 * @author timbo
 * @version v1.0
 */
public class Constant {
	/**
	 * ���϶���X������
	 */
	public static int LEFT_TOP_X = 0;
	/**
	 * ���϶���Y������
	 */
	public static int LEFT_TOP_Y = 0;
	/**
	 * ��Ļ�߶�
	 */
	public static int SCREEN_HEIGHT;
	/**
	 * ��Ļ���
	 */
	public static int SCREEN_WIDTH;
	/**
	 * ��Ļ�ϱ����׿��
	 */
	public static int UP_MARGIN = 60;
	/**
	 * ��Ļ�ϱ����Ŀ��
	 */
	public static int UP_BAR = 5;
	/**
	 * ��Ļ�ұ����׿��
	 */
	public static int RIGHT_MARGIN = 60;
	/**
	 * ��Ļ�ұ����Ŀ��
	 */
	public static int RIGHT_BAR = 5;

	/**
	 * ��Ϸ����X����
	 */
	public static int GAME_VIEW_X;
	/**
	 * ��Ϸ����Y����
	 */
	public static int GAME_VIEW_Y;
	/**
	 * ��Ϸ������
	 */
	public static int GAME_VIEW_WIDTH;
	/**
	 * ��Ϸ����߶�
	 */
	public static int GAME_VIEW_HEIGHT;
	/**
	 * �з�̹�˷��ӵ��Ŀ�����,0.8�Ѷ�����
	 */
	public static final float TANK_SEND_BULLET_POSSIBILITY = 0.8f;
	/**
	 * �з�̹�˸ı��˶�����Ŀ�����
	 */
	public static final float TANK_CHANGE_DIRECTION_POSSIBILITY = 0.4f;
	/**
	 * �з�̹������ı��˶��������µĿ�����(1-3/n)��nֵ,ֵԽ�������ߵĿ�����Խ��,5��6�Ϻ���
	 */
	public static final int VALUE_TANK_GO_DOWN = 6;
	/**
	 * Ӣ�۳�ʼ������
	 */
	public static final int HERO_LIFE = 3;
	/**
	 * Ӣ���н��ٶ�
	 */
	public static final int HERO_SPAN = 6;
	/**
	 * ��Ϸ�����ез�̹���������
	 */
	public static final int TANK_MAX_NUM_IN_GAME_VIEW = 4;
	/**
	 * ÿһ�ؿ��ез�̹��������
	 */
	public static final int TANK_TOTAL_NUM = 10;
	/**
	 * �з��ӵ��������
	 */
	public static final int TANK_BULLET_MAX_NUM = 4;
	/**
	 * �з��ӵ��ٶ�
	 */
	public static final int TANK_BULLET_SPAN = 3;
	/**
	 * Ӣ���ӵ���ʼ�ٶ�
	 */
	public static final int HERO_BULLET_INIT_SPAN = 1;
	/**
	 * Ӣ��̹�˳�һ�����Ǻ�,�ӵ��ٶ�
	 */
	public static final int HERO_BULLET_SPAN_FAST = 4;
	/**
	 * Ӣ���ӵ���ʼ�������
	 */
	public static final int HERO_BULLET_INIT_MAX_NUM = 1;
	/**
	 * Ӣ��̹�˳��������Ǻ�,�ӵ��������
	 */
	public static final int HERO_BULLET_MAX_NUM_MORE = 2;
	/**
	 * �ӵ���С
	 */
	public static final int BULLET_SIZE = 8;
	/**
	 * ̹�˴�С
	 */
	public static final int TANK_SIZE = 24;
	/**
	 * ̹�˴�С����ֵ��������ײ���,ֵԽ��̹��Խ����ͨ���ϰ�
	 */
	public static final int TANK_SIZE_REVISE = 3;
	/**
	 * �ϰ���ߴ�
	 */
	public static final int BARRIER_SIZE = 28 / 2;
	/**
	 * ���ѳߴ�
	 */
	public static final int HOME_SIZE = BARRIER_SIZE * 2;
	/**
	 * ������ߴ�
	 */
	public static final int REWARD_SIZE = BARRIER_SIZE * 2;
	/**
	 * �����º󣬻ָ�שǽ��ʱ��
	 */
	public static final int TIME_BACK_TO_BRICK_FROM_STONE = 15000;
	/**
	 * �Զ�ʱ���󣬵з�̹�˶�ס��ʱ��
	 */
	public static final int TIME_TANK_STOP = 15000;
	/**
	 * �Ա�������Ӣ��̹���ܱ�����ʱ��
	 */
	public static final int TIME_WEARING_PROTECTOR = 15000;
	/**
	 * �ϰ�����������
	 */
	public static int BARRIER_ARRAY_WIDTH; // RIGHT_MARGIN=60ʱ������Ϊ30������Ϊ22��
	/**
	 * �ϰ�����������
	 */
	public static int BARRIER_ARRAY_HEIGHT; // �ڳ�����û��ʵ���õ������ڿ���ʱ�����ͼ�����������

	// =================================================���ֲ���============================================//

	/**
	 * ��һ����Ϣ������ߵľ���
	 */
	public static int FIRST_NUMBER_WIDTH = 10;
	/**
	 * ÿһ������ռ��Ļ�Ŀ��
	 */
	public static int NUMBER_WIDTH = 12;
	/**
	 * ÿһ������ռ��Ļ�Ŀ��
	 */
	public static int NUMBER_TOTAL_WIDTH = 58;
	/**
	 * ����ռ��Ļ�ĸ߶�
	 */
	public static int NUMBER_HEIGHT = 30;
	// =================================================���ֲ���============================================//
	/**
	 * ��һ����Ϣ������ߵľ���
	 */
	public static int FIRST_HANZI_WIDTH;
	/**
	 * ����ռ��Ļ�Ŀ��
	 */
	public static int HANZI_WIDTH;
	/**
	 * ����ռ��Ļ�ĸ߶�
	 */
	public static int HANZI_HEIGHT;
	/**
	 * ��һ����Ϣ�ĸ߶�
	 */
	public static int FIRST_MESSAGE_HEIGHT;

	// ======================================�������ֵ========================================//
	// ========================================begin===========================================//
	/**
	 * ��������ܳߴ� (���)
	 */
	public static float BUTTON_TOTAL_WIDTH;
	/**
	 * ��������ܳߴ� (�߶�)
	 */
	public static float BUTTON_TOTAL_HEIGHT;
	/**
	 * ����������������X����
	 */
	public static float BUTTON_AREA_X;
	/**
	 * ����������������Y����
	 */
	public static float BUTTON_AREA_Y;
	/**
	 * ������̳ߴ� (���)
	 */
	public static float BUTTON_WIDTH;
	/**
	 * ������̳ߴ� (�߶�)
	 */
	public static float BUTTON_HEIGHT;
	/**
	 * ʣ��ߴ��һ�� (�߶�)
	 */
	public static float OTHER_WIDTH;
	/**
	 * ʣ��ߴ��һ�� (���)
	 */
	public static float OTHER_HEIGHT;
	/**
	 * �ĸ���ť���ϵ�X����
	 */
	public static float UP_X;
	/**
	 * �ĸ���ť���ϵ�Y����
	 */
	public static float UP_Y;
	/**
	 * �ĸ���ť���µ�X����
	 */
	public static float DOWN_X;
	/**
	 * �ĸ���ť���µ�Y����
	 */
	public static float DOWN_Y;
	/**
	 * �ĸ���ť�����X����
	 */
	public static float LEFT_X;
	/**
	 * �ĸ���ť�����Y����
	 */
	public static float LEFT_Y;
	/**
	 * �ĸ���ť���ҵ�X����
	 */
	public static float RIGHT_X;
	/**
	 * �ĸ���ť���ҵ�Y����
	 */
	public static float RIGHT_Y;
	/**
	 * �����ӵ�����ĳߴ� (���)
	 */
	public static float FIRE_BTN_WIDTH;
	/**
	 * �����ӵ�����ĳߴ� (�߶�)
	 */
	public static float FIRE_BTN_HEIGHT;
	/**
	 * �����ӵ���������ϵ�X����
	 */
	public static float FIRE_BTN_X;
	/**
	 * �����ӵ���������ϵ�Y����
	 */
	public static float FIRE_BTN_Y;

	// ======================================�������ֵ========================================//
	// =========================================end============================================//

	// ======================================ͼƬֵ===========================================//
	// =======================================begin===========================================//

	/**
	 * ������̵�����X����
	 */
	public static float BUTTON_X;
	/**
	 * ������̵�����Y����
	 */
	public static float BUTTON_Y;
	/**
	 * �������X����
	 */
	public static float RED_DOT_CENTER_X;
	/**
	 * �������Y����
	 */
	public static float RED_DOT_CENTER_Y;
	/**
	 * ����ͼƬ��X����
	 */
	public static float FIR_MAP_X;
	/**
	 * ����ͼƬ��Y����
	 */
	public static float FIR_MAP_Y;

	// ======================================ͼƬֵ===========================================//
	// ========================================end============================================//

	/**
	 * ��ʼ�������ķ���
	 */
	public static void initConst() {
		SCREEN_HEIGHT = ConstantHP.SCREEN_HEIGHT;
		SCREEN_WIDTH = ConstantHP.SCREEN_WIDTH;
		GAME_VIEW_X = ConstantHP.GAME_VIEW_X;
		GAME_VIEW_Y = ConstantHP.GAME_VIEW_Y;
		GAME_VIEW_WIDTH = ConstantHP.GAME_VIEW_WIDTH;
		GAME_VIEW_HEIGHT = ConstantHP.GAME_VIEW_HEIGHT;
		RIGHT_MARGIN = ConstantHP.RIGHT_MARGIN;// ��Ļ�ұ����׿��
		RIGHT_BAR = ConstantHP.RIGHT_BAR;// ��Ļ�ұ����Ŀ��

		NUMBER_WIDTH = ConstantHP.NUMBER_WIDTH;// ÿһ������ռ��Ļ�Ŀ��
		FIRST_MESSAGE_HEIGHT = ConstantHP.FIRST_MESSAGE_HEIGHT;// ��һ����Ϣ�ĸ߶�
		HANZI_HEIGHT = ConstantHP.HANZI_HEIGHT;// ����ռ��Ļ�ĸ߶�
		NUMBER_HEIGHT = ConstantHP.NUMBER_HEIGHT;// ����ռ��Ļ�ĸ߶�

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
		BARRIER_ARRAY_WIDTH = GAME_VIEW_WIDTH / BARRIER_SIZE; // �ϰ�����������
																// //RIGHT_MARGIN=60ʱ������Ϊ30������Ϊ22��
		BARRIER_ARRAY_HEIGHT = GAME_VIEW_HEIGHT / BARRIER_SIZE; // �ϰ�����������
																// //�ڳ�����û��ʵ���õ������ڿ���ʱ�����ͼ�����������
		System.out.println("��ͼ�������������" + Constant.BARRIER_ARRAY_WIDTH + ","
				+ Constant.BARRIER_ARRAY_HEIGHT);
	}

	/**
	 * �ж�һ�����ε��ĸ�����֮һ�Ƿ�����һ��������
	 * 
	 * @param xLeftTop1
	 *            ���ϵ�1 Xֵ
	 * @param yLeftTop1
	 *            ���ϵ�1 Yֵ
	 * @param length1
	 *            ���ϵ�1����
	 * @param width1
	 *            ���ϵ�1���
	 * @param xLeftTop2
	 *            ���ϵ�1 Xֵ
	 * @param yLeftTop2
	 *            ���ϵ�1 Yֵ
	 * @param length2
	 *            ���ϵ�1����
	 * @param width2���ϵ�1���
	 * 
	 * @return true �������ڣ�false ����������
	 */
	public static boolean oneIsInAnother(int xLeftTop1, int yLeftTop1,
			int length1, int width1, int xLeftTop2, int yLeftTop2, int length2,
			int width2) {
		if (pointIsInRect(xLeftTop1, yLeftTop1, xLeftTop2, yLeftTop2, length2,
				width2) || // ���϶���
				pointIsInRect(xLeftTop1 + length1, yLeftTop1, xLeftTop2,
						yLeftTop2, length2, width2) || // ���϶���
				pointIsInRect(xLeftTop1, yLeftTop1 + width1, xLeftTop2,
						yLeftTop2, length2, width2) || // ���¶���
				pointIsInRect(xLeftTop1 + length1, yLeftTop1 + width1,
						xLeftTop2, yLeftTop2, length2, width2) || // ���¶���

				pointIsInRect(xLeftTop2, yLeftTop2, xLeftTop1, yLeftTop1,
						length1, width1) || // ���϶���
				pointIsInRect(xLeftTop2 + length2, yLeftTop2, xLeftTop1,
						yLeftTop1, length1, width1) || // ���϶���
				pointIsInRect(xLeftTop2, yLeftTop2 + width2, xLeftTop1,
						yLeftTop1, length1, width1) || // ���¶���
				pointIsInRect(xLeftTop2 + length2, yLeftTop2 + width2,
						xLeftTop1, yLeftTop1, length1, width1) // ���¶���
		) {
			return true;
		}
		return false;
	}

	/**
	 * һ�����Ƿ��ھ����ڣ������߽磩
	 * 
	 * @param pointx
	 *            ��Xֵ(int)
	 * @param pointy
	 *            ��Yֵ(int)
	 * @param xLeftTop
	 *            �������ϵ�Xֵ(int)
	 * @param yLeftTop
	 *            �������ϵ�Yֵ(int)
	 * @param length
	 *            ���γ���(int)
	 * @param width
	 *            ���ο��(int)
	 * @return true �ھ����ڣ�false ���ھ�����
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
	 * һ�����Ƿ��ھ����ڣ������߽磩
	 * 
	 * @param pointx
	 *            ��Xֵ(float)
	 * @param pointy
	 *            ��Yֵ(float)
	 * @param xLeftTop
	 *            �������ϵ�Xֵ(float)
	 * @param yLeftTop
	 *            �������ϵ�Yֵ(float)
	 * @param length
	 *            ���γ���(float)
	 * @param width
	 *            ���ο��(float)
	 * @return true �ھ����ڣ�false ���ھ�����
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
	 * ���з�̹���Ƿ�����Ϸ�����еķ���
	 * 
	 * @param xTemp
	 *            X����
	 * @param yTemp
	 *            Y����
	 * @return true �ڽ����ڣ�false ���ڽ�����
	 */
	public static boolean isTankInGameView(int xTemp, int yTemp) {
		xTemp = xTemp + Constant.TANK_SIZE_REVISE;
		yTemp = yTemp + Constant.TANK_SIZE_REVISE;
		int tankSizeRevised = Constant.TANK_SIZE - 2
				* Constant.TANK_SIZE_REVISE - 2;// ������������ֵ��һ��������Ҫ�ֿ�д
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
	 * ���Ӣ��̹���Ƿ�����Ϸ�����еķ���
	 * 
	 * @param xTemp
	 *            X����
	 * @param yTemp
	 *            Y����
	 * @return true �ڽ����ڣ�false ���ڽ�����
	 */
	public static boolean isHeroInGameView(int xTemp, int yTemp) {
		xTemp = xTemp + Constant.TANK_SIZE_REVISE;
		yTemp = yTemp + Constant.TANK_SIZE_REVISE;
		int tankSizeRevised = Constant.TANK_SIZE - 2
				* Constant.TANK_SIZE_REVISE - 6;// ������������ֵ��һ��������Ҫ�ֿ�д
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
	 * ����ӵ�������Ӣ���ӵ����Ƿ�����Ϸ�����еķ���
	 * 
	 * @param xTemp
	 *            X����
	 * @param yTemp
	 *            Y����
	 * @return true �ڽ����ڣ�false ���ڽ�����
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

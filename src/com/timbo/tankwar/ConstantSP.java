package com.timbo.tankwar;
/**
 * ����������
 * @author timbo
 * @version v1.0
 */
public class ConstantSP {
	/**
	 * ��Ļ�߶�
	 */
	public static int SCREEN_HEIGHT=480;
	/**
	 * ��Ļ���
	 */
	public static int SCREEN_WIDTH=320;
	/**
	 * ��Ļ�ϱ����׿��
	 */
	public static final int UP_MARGIN=60;
	/**
	 * ��Ļ�ϱ����Ŀ��
	 */
	public static final int UP_BAR=5;
	
	/**
	 * ��Ϸ����X����
	 */
	public static int GAME_VIEW_X=Constant.LEFT_TOP_X;
	/**
	 * ��Ϸ����Y����
	 */
	public static int GAME_VIEW_Y=Constant.LEFT_TOP_Y+UP_MARGIN;
	/**
	 * ��Ϸ������
	 */
	public static int GAME_VIEW_WIDTH=SCREEN_WIDTH;
	/**
	 * ��Ϸ����߶�
	 */
	public static int GAME_VIEW_HEIGHT=SCREEN_HEIGHT-UP_MARGIN;
	
	//���ֲ���
	
	/**
	 * ��һ����Ϣ������ߵľ���
	 */
	public static final int FIRST_NUMBER_WIDTH=10;
	/**
	 * ÿһ������ռ��Ļ�Ŀ��
	 */
	public static final int NUMBER_WIDTH=12;
	/**
	 * ÿһ������ռ��Ļ�Ŀ��
	 */
	public static final int NUMBER_TOTAL_WIDTH=58;
	/**
	 * ����ռ��Ļ�ĸ߶�	
	 */
	public static final int NUMBER_HEIGHT=30;
	
	//���ֲ���
	
	/**
	 * ��һ����Ϣ������ߵľ���
	 */
	public static final int FIRST_HANZI_WIDTH=25;
	/**
	 * ����ռ��Ļ�Ŀ��
	 */
	public static final int HANZI_WIDTH=58;
	/**
	 * ����ռ��Ļ�ĸ߶�
	 */
	public static final int HANZI_HEIGHT=10;
	
	//======================================�������ֵ=========================================//
	//========================================begin===========================================//
	
	/**
	 * ��������ܳߴ� (���)
	 */
	public static final float BUTTON_TOTAL_WIDTH=70;
	/**
	 * ��������ܳߴ� (�߶�)
	 */
	public static final float BUTTON_TOTAL_HEIGHT=70;
	/**
	 * ����������������X����
	 */
	public static final float BUTTON_AREA_X=GAME_VIEW_X+GAME_VIEW_WIDTH-BUTTON_TOTAL_WIDTH-6;
	/**
	 * ����������������Y����
	 */
	public static final float BUTTON_AREA_Y=GAME_VIEW_Y+GAME_VIEW_HEIGHT-BUTTON_TOTAL_HEIGHT-6;	
	/**
	 * ������̳ߴ�(���)
	 */
	public static final float BUTTON_WIDTH=BUTTON_TOTAL_WIDTH/3;
	/**
	 * ������̳ߴ�(�߶�)
	 */
	public static final float BUTTON_HEIGHT=BUTTON_TOTAL_HEIGHT/3;
	/**
	 * ʣ��ߴ��һ��(���) (��������ܳߴ�-������̳ߴ�)/2
	 */
	public static final float OTHER_WIDTH=(BUTTON_TOTAL_WIDTH-BUTTON_WIDTH)/2;
	/**
	 * ʣ��ߴ��һ��(�߶�) (��������ܳߴ�-������̳ߴ�)/2
	 */
	public static final float OTHER_HEIGHT=(BUTTON_TOTAL_HEIGHT-BUTTON_HEIGHT)/2;
	/**
	 * �ĸ���ť���ϵ�X����
	 */
	public static final float UP_X=BUTTON_AREA_X+OTHER_WIDTH;
	/**
	 * �ĸ���ť���ϵ�Y����
	 */
	public static final float UP_Y=BUTTON_AREA_Y;
	/**
	 * �ĸ���ť���µ�X����
	 */
	public static final float DOWN_X=BUTTON_AREA_X+OTHER_WIDTH;
	/**
	 * �ĸ���ť���µ�Y����
	 */
	public static final float DOWN_Y=BUTTON_AREA_Y+BUTTON_HEIGHT+OTHER_HEIGHT;
	/**
	 * �ĸ���ť�����X����
	 */
	public static final float LEFT_X=BUTTON_AREA_X;
	/**
	 * �ĸ���ť�����Y����
	 */
	public static final float LEFT_Y=BUTTON_AREA_Y+OTHER_HEIGHT;
	/**
	 * �ĸ���ť���ҵ�X����
	 */
	public static final float RIGHT_X=BUTTON_AREA_X+BUTTON_WIDTH+OTHER_WIDTH;
	/**
	 * �ĸ���ť���ҵ�Y����
	 */
	public static final float RIGHT_Y=BUTTON_AREA_Y+OTHER_HEIGHT;
	/**
	 * �����ӵ�����ĳߴ� (���)
	 */
	public static final float FIRE_BTN_WIDTH=50;
	/**
	 * �����ӵ�����ĳߴ� (�߶�)
	 */
	public static final float FIRE_BTN_HEIGHT=50;
	/**
	 * �����ӵ���������ϵ�X����
	 */
	public static final float FIRE_BTN_X=GAME_VIEW_X+2;
	/**
	 * �����ӵ���������ϵ�Y����
	 */
	public static final float FIRE_BTN_Y=GAME_VIEW_Y+GAME_VIEW_HEIGHT-FIRE_BTN_HEIGHT-2;	
	//======================================�������ֵ========================================//
	//=========================================end===========================================//
	
	//======================================ͼƬֵ===========================================//
	//=======================================begin==========================================//
	
	/**
	 * ������̵�����X����
	 */
	public static final float BUTTON_X=BUTTON_AREA_X-7;
	/**
	 * ������̵�����Y����
	 */
	public static final float BUTTON_Y=BUTTON_AREA_Y-7;
	/**
	 * �������X����
	 */
	public static final float RED_DOT_CENTER_X=BUTTON_AREA_X+BUTTON_WIDTH-3;
	/**
	 * �������Y����
	 */
	public static final float RED_DOT_CENTER_Y=BUTTON_AREA_Y+BUTTON_HEIGHT-3;
	/**
	 * ����ͼƬ��X����
	 */
	public static final float FIR_MAP_X=FIRE_BTN_X-2;
	/**
	 * ����ͼƬ��Y����
	 */
	public static final float FIR_MAP_Y=FIRE_BTN_Y+3;
	//======================================ͼƬֵ===========================================//
	//=======================================end============================================//
}

package com.timbo.tankwar;
/**
 * 横屏常量类
 * @author timbo
 * @version v1.0
 */
public class ConstantHP {
	/**
	 * 屏幕高度
	 */
	public static int SCREEN_HEIGHT=320;
	/**
	 * 屏幕宽度
	 */
	public static int SCREEN_WIDTH=740;
	/**
	 * 屏幕右边留白宽度
	 */
	public static final int RIGHT_MARGIN=60;
	/**
	 * 屏幕右边条的宽度
	 */
	public static final int RIGHT_BAR=5;
	/**
	 * 游戏界面X坐标
	 */
	public static int GAME_VIEW_X=Constant.LEFT_TOP_X;
	/**
	 * 游戏界面Y坐标
	 */
	public static int GAME_VIEW_Y=Constant.LEFT_TOP_Y;
	/**
	 * 游戏界面宽度
	 */
	public static int GAME_VIEW_WIDTH=SCREEN_WIDTH-RIGHT_MARGIN;;
	/**
	 * 游戏界面高度
	 */
	public static int GAME_VIEW_HEIGHT=SCREEN_HEIGHT;
	/**
	 * 每一个数字占屏幕的宽度
	 */
	public static final int NUMBER_WIDTH=12;
	/**
	 * 第一条信息的高度
	 */
	public static final int FIRST_MESSAGE_HEIGHT=25;
	/**
	 * 汉字占屏幕的高度
	 */
	public static final int HANZI_HEIGHT=6;
	/**
	 * 数字占屏幕的高度
	 */
	public static final int NUMBER_HEIGHT=28;
	
	//======================================标记区域值================================================//
	//=======================================begin===================================================//
	
	/**
	 * 虚拟键盘总尺寸(宽度)
	 */
	public static final float BUTTON_TOTAL_WIDTH=70;
	/**
	 * 虚拟键盘总尺寸(高度)
	 */
	public static final float BUTTON_TOTAL_HEIGHT=70;
	/**
	 * 虚拟键盘区域的左上X坐标
	 */
	public static final float BUTTON_AREA_X=GAME_VIEW_X+GAME_VIEW_WIDTH-BUTTON_TOTAL_WIDTH+46;
	/**
	 * 虚拟键盘区域的左上Y坐标
	 */
	public static final float BUTTON_AREA_Y=GAME_VIEW_Y+GAME_VIEW_HEIGHT-BUTTON_TOTAL_HEIGHT-8;	
	/**
	 * 虚拟键盘尺寸 (宽度)
	 */
	public static final float BUTTON_WIDTH=BUTTON_TOTAL_WIDTH/3;
	/**
	 * 虚拟键盘尺寸 (高度)
	 */
	public static final float BUTTON_HEIGHT=BUTTON_TOTAL_HEIGHT/3;
	/**
	 * 剩余尺寸的一半(宽度) (虚拟键盘总尺寸-虚拟键盘尺寸)/2
	 */
	public static final float OTHER_WIDTH=(BUTTON_TOTAL_WIDTH-BUTTON_WIDTH)/2;
	/**
	 * 剩余尺寸的一半(高度) (虚拟键盘总尺寸-虚拟键盘尺寸)/2
	 */
	public static final float OTHER_HEIGHT=(BUTTON_TOTAL_HEIGHT-BUTTON_HEIGHT)/2;
	/**
	 * 四个按钮的上点X坐标
	 */
	public static final float UP_X=BUTTON_AREA_X+OTHER_WIDTH;
	/**
	 * 四个按钮的上点Y坐标
	 */
	public static final float UP_Y=BUTTON_AREA_Y;
	/**
	 * 四个按钮的下点X坐标
	 */
	public static final float DOWN_X=BUTTON_AREA_X+OTHER_WIDTH;
	/**
	 * 四个按钮的下点X坐标
	 */
	public static final float DOWN_Y=BUTTON_AREA_Y+BUTTON_HEIGHT+OTHER_HEIGHT;
	/**
	 * 四个按钮的左点X坐标
	 */
	public static final float LEFT_X=BUTTON_AREA_X;
	/**
	 * 四个按钮的左点X坐标
	 */
	public static final float LEFT_Y=BUTTON_AREA_Y+OTHER_HEIGHT;
	/**
	 * 四个按钮的右点X坐标
	 */
	public static final float RIGHT_X=BUTTON_AREA_X+BUTTON_WIDTH+OTHER_WIDTH;
	/**
	 * 四个按钮的右点X坐标
	 */
	public static final float RIGHT_Y=BUTTON_AREA_Y+OTHER_HEIGHT;
	/**
	 * 发射子弹区域的尺寸（宽度）
	 */
	public static final float FIRE_BTN_WIDTH=50;
	/**
	 * 发射子弹区域的尺寸（高度）
	 */
	public static final float FIRE_BTN_HEIGHT=50;
	/**
	 * 发射子弹区域的左上点X坐标
	 */
	public static final float FIRE_BTN_X=GAME_VIEW_X+2;
	/**
	 * 发射子弹区域的左上点Y坐标
	 */
	public static final float FIRE_BTN_Y=GAME_VIEW_Y+GAME_VIEW_HEIGHT-FIRE_BTN_HEIGHT-2;
	
	//======================================标记区域值=============================================//
	//============================================================================================//
	
	//======================================图片值================================================//
	//======================================begin=================================================//
	
	/**
	 * 虚拟键盘的左上X坐标
	 */
	public static final float BUTTON_X=BUTTON_AREA_X-7;
	/**
	 * 虚拟键盘的左上Y坐标
	 */
	public static final float BUTTON_Y=BUTTON_AREA_Y-7;
	/**
	 * 红点坐标X坐标
	 */
	public static final float RED_DOT_CENTER_X=BUTTON_AREA_X+BUTTON_WIDTH-3;
	/**
	 * 红点坐标Y坐标
	 */
	public static final float RED_DOT_CENTER_Y=BUTTON_AREA_Y+BUTTON_HEIGHT-3;
	/**
	 * 发射图片的X坐标
	 */
	public static final float FIR_MAP_X=FIRE_BTN_X-2;
	/**
	 * 发射图片的Y坐标
	 */
	public static final float FIR_MAP_Y=FIRE_BTN_Y+3;
	//======================================图片值================================================//
	//======================================end==================================================//
}

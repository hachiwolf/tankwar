package com.timbo.tankwar;

enum ScreenOrien {
	/**
	 * 表示横屏的枚举值
	 */
	HP,
	/**
	 * 表示竖屏的枚举值
	 */
	SP
}

/**
 * 缩放计算的结果类
 * 
 * @author Administrator zuolingfeng
 * @version v1.0
 */
public class ScreenScaleResult {
	/**
	 * 左上角X坐标
	 */
	int lucX;
	/**
	 * 左上角y坐标
	 */
	int lucY;
	/**
	 * 缩放比例
	 */
	float ratio;
	/**
	 * 横竖屏情况
	 */
	ScreenOrien so;

	public ScreenScaleResult(int lucX, int lucY, float ratio, ScreenOrien so) {
		this.lucX = lucX;
		this.lucY = lucY;
		this.ratio = ratio;
		this.so = so;
	}

	public String toString() {
		return "lucX=" + lucX + ", lucY=" + lucY + ", ratio=" + ratio + ", "
				+ so;
	}
}
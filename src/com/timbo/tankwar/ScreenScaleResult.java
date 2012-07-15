package com.timbo.tankwar;

enum ScreenOrien {
	/**
	 * ��ʾ������ö��ֵ
	 */
	HP,
	/**
	 * ��ʾ������ö��ֵ
	 */
	SP
}

/**
 * ���ż���Ľ����
 * 
 * @author Administrator zuolingfeng
 * @version v1.0
 */
public class ScreenScaleResult {
	/**
	 * ���Ͻ�X����
	 */
	int lucX;
	/**
	 * ���Ͻ�y����
	 */
	int lucY;
	/**
	 * ���ű���
	 */
	float ratio;
	/**
	 * ���������
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
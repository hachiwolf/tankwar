package com.timbo.tankwar;


/**
 * 保护英雄线程类
 * @author timbo
 * @version v1.0
 */
public class ProtectHeroThread extends Thread {
	Hero hero;

	public ProtectHeroThread(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void run() {
		hero.wearProtector();
		try {
			Thread.sleep(Constant.TIME_WEARING_PROTECTOR);// 一定时间后去掉保护器
		} catch (Exception e) {
			e.printStackTrace();
		}
		hero.removeProtector();
	}
}

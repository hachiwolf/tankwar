package com.timbo.tankwar;
/**
 * �ٶȼӿ�ĵз�̹����
 * @author timbo
 * @version v1.0
 */
public class TankFast extends Tank {

	public TankFast(int direction, int x, int y) {
		super(direction, x, y);
		this.tanki = MySurfaceView.tanki2;
		this.span = 4;
		this.life = 1;
	}

	@Override
	void explode() {
		super.explode();
		MySurfaceView.score += 2;
	}
}

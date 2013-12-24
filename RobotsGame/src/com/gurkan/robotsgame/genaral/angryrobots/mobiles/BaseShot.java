package com.gurkan.robotsgame.genaral.angryrobots.mobiles;

public class BaseShot extends GameObject {

	private float dx;
	private float dy;
	private float shotSpeed;

	public BaseShot() {
		super();
	}

	public void setShotSpeed(float shotSpeed) {
		this.shotSpeed = shotSpeed;
	}

	public void fire(float x, float y, float dx, float dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void update(float delta) {
		stateTime += delta;
		float n = shotSpeed * delta;
		x += dx * n;
		y += dy * n;
	}
}

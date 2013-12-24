package com.gurkan.robotsgame.genaral;

import com.badlogic.gdx.graphics.Color;

import static com.badlogic.gdx.math.MathUtils.*;
import static com.gurkan.robotsgame.genaral.MathUtils.*;

public class Particle {

	private final float MIN_SPEED = 3.125f;
	private final float MAX_SPEED = 6.25f;
	private final float DECAY = 2.0f;

	public boolean active;
	public float x;
	public float y;
	public Color color;
	public final float size;
	final float halfSize;
	float dx;
	float dy;
	float r;
	float g;
	float b;
	float a;

	public Particle(float size) {
		this.color = new Color();
		this.size = size;
		this.halfSize = size / 2;
	}

	public void spawn(Color c, float x, float y) {
		this.active = true;
		this.x = x - halfSize;
		this.y = y - halfSize;
		color.set(c);
		r = c.r;
		g = c.g;
		b = c.b;
		a = 3.0f;
		float direction = random((float) -PI, PI);
		float speed = random(MIN_SPEED, MAX_SPEED);
		dx = cos(direction) * speed;
		dy = sin(direction) * speed;
	}

	public void update(float delta) {
		x += dx * delta;
		y += dy * delta;
		dx *= (1.0 - DECAY * delta * 0.5f);
		dy *= (1.0 - DECAY * delta * 0.5f);
		a *= (1.0 - DECAY * delta);
		color.a = min(1.0f, a);
		color.r = min(1.0f, r + max(0, (a - 1.0f)));
		color.g = min(1.0f, g + max(0, (a - 1.0f)));
		color.b = min(1.0f, b + max(0, (a - 1.0f)));
		active = active && a > 0.1f;
	}
}

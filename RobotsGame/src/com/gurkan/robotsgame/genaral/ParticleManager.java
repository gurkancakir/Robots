package com.gurkan.robotsgame.genaral;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

public class ParticleManager {

	private final Array<Particle> particles;
	private final int maxParticles;
	private int index;

	public ParticleManager(int maxParticles, float size) {
		particles = new Array<Particle>(maxParticles);
		this.maxParticles = maxParticles;
		for (int i = 0; i < maxParticles; i++) {
			particles.add(new Particle(size));
		}
		index = 0;
	}

	public Array<Particle> getParticles() {
		return particles;
	}

	public void clear() {
		for (Particle particle : particles) {
			particle.active = false;
		}
	}

	public void add(float x, float y, int n, Color c) {
		for (int i = 0; i < n; i++) {
			particles.get(index).spawn(c, x, y);
			if (++index == maxParticles) {
				index = 0;
			}
		}
	}

	public void update(float delta) {
		for (Particle particle : particles) {
			if (particle.active) {
				particle.update(delta);
			}
		}
	}
}
package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.graphics.Color;
import com.gurkan.robotsgame.genaral.ParticleManager;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.BaseShot;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.Player;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.Robot;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.World;

class ParticleAdapter implements WorldListener {

	final int PARTICLES = 32;

	final private World world;
	final private ParticleManager particleManager;
	private Color robotColor;
	private Color shotExplosionColor;

	public ParticleAdapter(World world, ParticleManager particleManager) {
		this.world = world;
		this.particleManager = particleManager;
		shotExplosionColor = new Color(1.0f, 0.5f, 0.0f, 1.0f);
	}

	public void setRobotColor(Color color) {
		this.robotColor = color;
	}

	public void update(float delta) {
		particleManager.update(delta);
	}

	@Override
	public void onEnteredRoom(float time, int robots) {
		particleManager.clear();
	}

	@Override
	public void onPlayerHit() {
		Player player = world.getPlayer();
		float x = player.x + player.width / 2;
		float y = player.y + player.height / 2;
		particleManager.add(x, y, 2 * PARTICLES, Color.WHITE);
	}

	@Override
	public void onRobotDestroyed(Robot robot) {
		float x = robot.x + robot.width / 2;
		float y = robot.y + robot.height / 2;
		particleManager.add(x, y, PARTICLES, robotColor);
	}

	@Override
	public void onShotDestroyed(BaseShot shot) {
		float x = shot.x + shot.width / 2;
		float y = shot.y + shot.height / 2;
		particleManager.add(x, y, PARTICLES / 8, shotExplosionColor);
	}

	@Override
	public void onCaptainActivated(float time) {
	}

	@Override
	public void onExitedRoom(float time, int robots) {
	}

	@Override
	public void onPlayerFired() {
	}

	@Override
	public void onPlayerSpawned() {
	}

	@Override
	public void onRobotFired(Robot robot) {
	}

	@Override
	public void onRobotHit(Robot robot) {
	}

	@Override
	public void onWorldReset() {
	}

}
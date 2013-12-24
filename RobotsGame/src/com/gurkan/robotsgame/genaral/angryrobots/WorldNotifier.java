package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.utils.Array;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.BaseShot;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.Robot;

public class WorldNotifier implements WorldListener {

	private final Array<WorldListener> listeners;

	public WorldNotifier() {
		listeners = new Array<WorldListener>();
	}

	public void addListener(WorldListener listener) {
		listeners.add(listener);
	}

	@Override
	public void onCaptainActivated(float time) {
		for (WorldListener listener : listeners) {
			listener.onCaptainActivated(time);
		}
	}

	@Override
	public void onEnteredRoom(float time, int robots) {
		for (WorldListener listener : listeners) {
			listener.onEnteredRoom(time, robots);
		}
	}

	@Override
	public void onExitedRoom(float time, int robots) {
		for (WorldListener listener : listeners) {
			listener.onExitedRoom(time, robots);
		}
	}

	@Override
	public void onPlayerFired() {
		for (WorldListener listener : listeners) {
			listener.onPlayerFired();
		}
	}

	@Override
	public void onPlayerHit() {
		for (WorldListener listener : listeners) {
			listener.onPlayerHit();
		}
	}

	@Override
	public void onPlayerSpawned() {
		for (WorldListener listener : listeners) {
			listener.onPlayerSpawned();
		}
	}

	@Override
	public void onRobotDestroyed(Robot robot) {
		for (WorldListener listener : listeners) {
			listener.onRobotDestroyed(robot);
		}
	}

	@Override
	public void onRobotFired(Robot robot) {
		for (WorldListener listener : listeners) {
			listener.onRobotFired(robot);
		}
	}

	@Override
	public void onRobotHit(Robot robot) {
		for (WorldListener listener : listeners) {
			listener.onRobotHit(robot);
		}
	}

	@Override
	public void onShotDestroyed(BaseShot shot) {
		for (WorldListener listener : listeners) {
			listener.onShotDestroyed(shot);
		}
	}

	@Override
	public void onWorldReset() {
		for (WorldListener listener : listeners) {
			listener.onWorldReset();
		}
	}
}
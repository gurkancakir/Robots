package com.gurkan.robotsgame.genaral.angryrobots;

import com.gurkan.robotsgame.genaral.angryrobots.mobiles.BaseShot;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.Robot;

public interface WorldListener {
	public void onCaptainActivated(float time);

	public void onEnteredRoom(float time, int robots);

	public void onExitedRoom(float time, int robots);

	public void onPlayerFired();

	public void onPlayerHit();

	public void onPlayerSpawned();

	public void onRobotDestroyed(Robot robot);

	public void onRobotFired(Robot robot);

	public void onRobotHit(Robot robot);

	public void onShotDestroyed(BaseShot shot);

	public void onWorldReset();
}
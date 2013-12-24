package com.gurkan.robotsgame.genaral.angryrobots.mobiles;

import com.gurkan.robotsgame.genaral.Config;
import com.gurkan.robotsgame.genaral.angryrobots.Assets;



public class RobotShot extends BaseShot {

	private static final float DEFAULT_SHOT_SPEED = Config.asFloat(
			"RobotShot.slowSpeed", 4.6875f);

	private GameObject owner;

	public RobotShot() {
		width = Assets.robotShotWidth;
		height = Assets.robotShotHeight;
		setShotSpeed(DEFAULT_SHOT_SPEED);
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

	@Override
	public boolean intersects(GameObject other) {
		return (owner != other) && super.intersects(other);
	}
}
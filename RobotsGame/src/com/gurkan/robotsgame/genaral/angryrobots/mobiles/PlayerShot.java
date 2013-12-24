package com.gurkan.robotsgame.genaral.angryrobots.mobiles;

import com.gurkan.robotsgame.genaral.Config;
import com.gurkan.robotsgame.genaral.angryrobots.Assets;



public class PlayerShot extends BaseShot {

	private static final float SHOT_SPEED = Config.asFloat("PlayerShot.speed",
			31.25f);

	public PlayerShot() {
		width = Assets.playerShotWidth;
		height = Assets.playerShotHeight;
		setShotSpeed(SHOT_SPEED);
	}
}
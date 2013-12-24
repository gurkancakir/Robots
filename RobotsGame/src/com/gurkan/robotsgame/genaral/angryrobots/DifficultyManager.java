package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.graphics.Color;

public interface DifficultyManager {
	Color getRobotColor();

	int getNumberOfRobots();

	int getNumberOfRobotShots();

	float getRobotShotSpeed();
}

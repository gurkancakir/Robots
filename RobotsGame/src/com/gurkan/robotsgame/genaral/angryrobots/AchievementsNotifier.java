package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.utils.Array;
import com.gurkan.robotsgame.genaral.angryrobots.StatusManager.Achievements;

public class AchievementsNotifier implements AchievementsListener {

	private final Array<AchievementsListener> listeners;

	public AchievementsNotifier() {
		this.listeners = new Array<AchievementsListener>();
	}

	public void addListener(AchievementsListener listener) {
		listeners.add(listener);
	}

	@Override
	public void onAttained(Achievements achievement) {
		for (AchievementsListener listener : listeners) {
			listener.onAttained(achievement);
		}
	}

}
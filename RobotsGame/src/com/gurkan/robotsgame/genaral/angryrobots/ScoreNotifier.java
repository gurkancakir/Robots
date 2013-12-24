package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.utils.Array;

public class ScoreNotifier implements ScoreListener {

	private Array<ScoreListener> listeners;

	public ScoreNotifier() {
		listeners = new Array<ScoreListener>();
	}

	public void addListener(ScoreListener listener) {
		listeners.add(listener);
	}

	@Override
	public void onScoreChanged(int score) {
		for (ScoreListener listener : listeners) {
			listener.onScoreChanged(score);
		}
	}

	@Override
	public void onLivesChanged(int lives) {
		for (ScoreListener listener : listeners) {
			listener.onLivesChanged(lives);
		}
	}
}
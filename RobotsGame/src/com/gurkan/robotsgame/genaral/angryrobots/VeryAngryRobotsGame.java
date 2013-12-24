package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.gurkan.robotsgame.genaral.angryrobots.StatusManager.Achievements;

public class VeryAngryRobotsGame extends Game implements AchievementsListener {

	Screen mainMenuScreen;
	Screen playingScreen;
	ScoresScreen scoresScreen;
	IShowScores scoreDisplayer;
	ISubmitScores scoreSubmitter;
	AchievementsListener achievementsListener;

	/**
	 * Creates all the screens that the game will need, then switches to the
	 * main menu.
	 */
	@Override
	public void create() {
		Assets.load();
		mainMenuScreen = new MainMenuScreen(this);
		playingScreen = new WorldPresenter(this);
		scoresScreen = new ScoresScreen(this);
		setScreen(mainMenuScreen);
	}

	public void submitScore(int score) {
		if (scoreSubmitter != null) {
			scoreSubmitter.submitScore(score);
		}
	}

	public void showScores() {
		if (scoreDisplayer != null) {
			scoreDisplayer.showScores();
		}
	}

	@Override
	public void onAttained(Achievements achievement) {
		if (achievementsListener != null) {
			achievementsListener.onAttained(achievement);
		}
	}

	public void setScoreDisplayer(IShowScores scoreDisplayer) {
		this.scoreDisplayer = scoreDisplayer;
	}

	public void setScoreSubmitter(ISubmitScores scoreSubmitter) {
		this.scoreSubmitter = scoreSubmitter;
	}

	public void setAchievementsListener(AchievementsListener listener) {
		this.achievementsListener = listener;
	}

	public boolean canShowScores() {
		return scoreDisplayer != null;
	}
}
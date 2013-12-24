package com.gurkan.robotsgame.genaral.angryrobots;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gurkan.robotsgame.genaral.CameraHelper;
import com.gurkan.robotsgame.genaral.CameraHelper.ViewportMode;
import com.gurkan.robotsgame.genaral.Config;
import com.gurkan.robotsgame.genaral.ScoreString;
import com.gurkan.robotsgame.genaral.angryrobots.StatusManager.Achievements;
import com.gurkan.robotsgame.genaral.angryrobots.mobiles.World;

import static com.gurkan.robotsgame.genaral.angryrobots.Assets.*;

public class StatusView implements ScoreListener, AchievementsListener {

	private static final float ACHIEVEMENT_DISPLAY_TIME = Config.asFloat(
			"status.achievementDisplayTime", 10.0f);
	private static final float ACHIEVEMENT_FLASH_CYCLE = Config.asFloat(
			"status.achievementFlashCycleLength", 1.0f);
	private static final float ACHIEVEMENT_FLASH_ON_PERCENT = Config.asFloat(
			"status.achievementFlashOnPercent", 50.0f);
	private static final float ACHIEVEMENT_FLASH_ON_TIME = ACHIEVEMENT_FLASH_CYCLE
			* ACHIEVEMENT_FLASH_ON_PERCENT / 100.0f;

	private static final String RESUME_TEXT = "Tap to resume or press <<Back>> to quit";

	private final World world;
	private final OrthographicCamera statusCam;
	private final SpriteBatch spriteBatch;
	private ScoreString scoreString;
	private int lives;
	private Achievements achievement;
	private float achievementTime;
	private float now;

	public StatusView(World world) {
		this.world = world;
		scoreString = new ScoreString();
		statusCam = CameraHelper.createCamera2(ViewportMode.PIXEL_PERFECT,
				VIRTUAL_WIDTH, VIRTUAL_HEIGHT, Assets.pixelDensity);
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(statusCam.combined);
	}

	public void render(float delta) {
		now += delta;
		spriteBatch.begin();
		if (!world.isPaused()) {
			drawPauseButton();
			drawScore();
			drawAchievements();
			drawLives();
		} else {
			drawPaused();
		}
		spriteBatch.end();
	}

	private void drawPauseButton() {
		float w = Assets.pauseButton.getRegionWidth() / Assets.pixelDensity;
		float h = Assets.pauseButton.getRegionHeight() / Assets.pixelDensity;
		float y = VIRTUAL_HEIGHT - h;
		float x = 0.0f;
		spriteBatch.draw(Assets.pauseButton, x, y, w, h);
	}

	private void drawScore() {
		Assets.scoreFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		Assets.scoreFont.draw(spriteBatch, scoreString, 2, VIRTUAL_HEIGHT);
		;
	}

	private void drawAchievements() {
		if (achievement != null) {
			float elapsed = now - achievementTime;
			if (elapsed < ACHIEVEMENT_DISPLAY_TIME) {
				if (elapsed % ACHIEVEMENT_FLASH_CYCLE < ACHIEVEMENT_FLASH_ON_TIME) {
					String summary = achievement.summary();
					float x = VIRTUAL_WIDTH * 0.5f;
					float w = VIRTUAL_WIDTH
							- x
							- (Assets.playerWalkingRight1.getRegionHeight() / Assets.pixelDensity)
							* 4;
					float y = VIRTUAL_HEIGHT - 1
							+ Assets.textFont.getCapHeight() / 2;
					Assets.textFont.drawWrapped(spriteBatch, summary, x, y, w,
							HAlignment.LEFT);
				}
			} else {
				achievement = null;
			}
		}
	}

	private void drawLives() {
		float h = Assets.playerWalkingRight1.getRegionHeight()
				/ Assets.pixelDensity;
		float y = VIRTUAL_HEIGHT - h;
		float w = Assets.playerWalkingRight1.getRegionWidth()
				/ Assets.pixelDensity;
		float x = VIRTUAL_WIDTH - w;
		for (int i = 0; i < lives - 1; i++) {
			spriteBatch.draw(Assets.playerWalkingRight1, x, y, w, h);
			x -= w;
		}
	}

	private void drawPaused() {
		if (world.getPausedTime() % 1.0f < 0.5f) {
			float y = VIRTUAL_HEIGHT - 1 + Assets.scoreFont.getCapHeight() / 2;
			Assets.textFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			Assets.textFont.drawWrapped(spriteBatch, RESUME_TEXT, 0.0f, y,
					VIRTUAL_WIDTH, HAlignment.CENTER);
		}
	}

	@Override
	public void onScoreChanged(int score) {
		scoreString.setScore(score);
	}

	@Override
	public void onLivesChanged(int lives) {
		this.lives = lives;
	}

	@Override
	public void onAttained(Achievements achievement) {
		// TODO Auto-generated method stub
		
	}

	

	
}
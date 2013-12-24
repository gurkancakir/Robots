package com.gurkan.robotsgame.genaral;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Grid {

	private final int cols;
	private final int rows;
	private final float cellWidth;
	private final float cellHeight;
	private final Array<Array<Rectangle>> grid;
	private Array<Rectangle> result;

	public Grid(int cols, int rows, float width, float height) {
		this.cols = cols;
		this.rows = rows;
		this.cellWidth = width / cols;
		this.cellHeight = height / rows;
		this.grid = new Array<Array<Rectangle>>(cols * rows);
		for (int i = 0; i < cols * rows; i++) {
			grid.add(new Array<Rectangle>());
		}
		this.result = new Array<Rectangle>();
	}

	public void clear() {
		for (Array<Rectangle> v : grid) {
			v.clear();
		}
	}

	public void add(Rectangle r) {
		int minX = MathUtils.max(0, cellX(r.x));
		int maxX = MathUtils.min(cols - 1, cellX(r.x + r.width));
		int minY = MathUtils.max(0, cellY(r.y));
		int maxY = MathUtils.min(rows - 1, cellY(r.y + r.height));
		for (int y = minY; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				int shv = getGridCell(x, y);
				Array<Rectangle> values = grid.get(shv);
				values.add(r);
			}
		}
	}

	public Array<Rectangle> get(Rectangle r) {
		result.clear();
		int minX = MathUtils.max(0, cellX(r.x));
		int maxX = MathUtils.min(cols - 1, cellX(r.x + r.width));
		int minY = MathUtils.max(0, cellY(r.y));
		int maxY = MathUtils.min(rows - 1, cellY(r.y + r.height));
		for (int y = minY; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				int shv = getGridCell(x, y);
				result.addAll(grid.get(shv));
			}
		}
		return result;
	}

	private int cellX(float x) {
		return (int) (x / cellWidth);
	}

	private int cellY(float y) {
		return (int) (y / cellHeight);
	}

	private int getGridCell(int x, int y) {
		return x + y * cols;
	}
}
package vds.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

	public static List<List<Point>> getTreeGrid(int levelCount, int maxHorixontalSpan, int levelDisplayGap) {

		List<List<Point>> grid = new ArrayList<>();
		List<Point> gridRow = new ArrayList<>();

		int leafCount = Utils.pow2(levelCount - 1);
		int baseStep = maxHorixontalSpan / (leafCount);
		int x = 0, y = 0, s = 0;
		int levelNodeCount = 0;
		for (int level = 1; level <= levelCount; level++) {
			x = (baseStep * (Utils.pow2(levelCount - level) - 1)) / 2;
			s = Utils.pow2(levelCount - level) * baseStep;
			levelNodeCount = Utils.pow2(level - 1);
			gridRow = new ArrayList<>();
			for (int j = 0; j < levelNodeCount; j++) {
				gridRow.add(new Point(x, y));
				x += s;
			}
			grid.add(gridRow);
			y += levelDisplayGap;
		}
		return grid;
	}

}

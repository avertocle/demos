package vds.utils;

import java.awt.Toolkit;

public class SystemUtils {

	public static final int MIN_NODE_RADIUS = 10;

	public static int getScreenWidth() {
		return (Toolkit.getDefaultToolkit().getScreenSize().width - 100);
	}

	public static int getScreenHeight() {
		return (Toolkit.getDefaultToolkit().getScreenSize().height - 100);
	}

}

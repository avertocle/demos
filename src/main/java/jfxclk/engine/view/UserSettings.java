package jfxclk.engine.view;

public class UserSettings {

	/* TODO :: make these final and load from file */
	public int[] START_TIME = { 1, 30 };
	public int[] END_TIME = { 8, 0 };

	public int[] WARNING_TIME = { 2, 40 };
	public int[] LOGOFF_TIME = { 2, 5 };
	public int[] SHUTDOWN_TIME = { 2, 45 };

	public int SNOOZE_TIME_MIN = 5;

	public int REFRESH_INTERVAL_MILLI = 60 * 1000;
	public String DEFAULT_CLOCK_NAME = "Clock#1";
	public String DEFAULT_TIME_FORMAT = "HH:mm";
	public Stage stage;

	public String STYLE_LABEL = "-fx-background-color: #001B6B;-fx-text-fill: #9E0028;";
	public String STYLE_SCENE = "-fx-background-color: #001B6B;";

	public class Stage {
		public String STAGE_TITLE = "Shitty Clock";
		public int STAGE_WIDTH = 1000;
		public int STAGE_HIEGHT = 600;
	}

	/********************************************************************************
	 * Methods
	 ********************************************************************************/

	public static UserSettings userSettings = new UserSettings();

	public static UserSettings gi() {
		return userSettings;
	}

	private UserSettings() {
		stage = new Stage();
	}

	public void writeToFile() {
	}

	public void loadFromFile(String fileName) {

	}
}

package jfxclk.engine.view;

public class UserSettings {

	/* TODO :: make these final and load from file */

	public int refreshIntervalMilliSeconds = 60*1000;
	public String DEFAULT_CLOCK_NAME = "Clock#1";
	public String DEFAULT_TIME_FORMAT = "HH:mm";
	public Stage stage;

	public class Stage {
		public String STAGE_TITLE = "Shitty Clock";
		public int STAGE_WIDTH = 400;
		public int STAGE_HIEGHT = 200;
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

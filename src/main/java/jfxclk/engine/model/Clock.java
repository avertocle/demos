package jfxclk.engine.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jfxclk.engine.view.UserSettings;

public class Clock {

	private static int ctr = 1;

	private int id;
	private DateFormat dateFormat;
	private String displayName;
	private long boost;

	/**
	 * @param displayName
	 * @param boost : in seconds
	 */
	public Clock(String displayName, long boost) {
		this.id = ctr++;
		this.boost = boost;
		this.dateFormat = new SimpleDateFormat(UserSettings.gi().DEFAULT_TIME_FORMAT);
		this.displayName = displayName;
	}

	public ModelResponse getModelResponse() {
		Date date = new Date(System.currentTimeMillis() + boost*1000);
		return new ModelResponse(displayName, dateFormat.format(date));
	}

	public int getId() {
		return id;
	}

}

package jfxclk.engine.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	private static int ctr=1;

	private int id;
	private DateFormat dateFormat;
	private String displayName;

	public Clock(String displayName, String dateFormatStirng) {
		this.id = ctr++;
		this.dateFormat = new SimpleDateFormat(dateFormatStirng);
		this.displayName = displayName;
	}

	public ModelResponse getModelResponse() {
		return new ModelResponse(displayName, dateFormat.format(new Date()));
	}

	public int getId() {
		return id;
	}

}

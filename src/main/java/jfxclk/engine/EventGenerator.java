package jfxclk.engine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import jfxclk.engine.model.Clock;
import jfxclk.engine.model.ModelResponse;

public class EventGenerator {

	private static Logger logger = Logger.getLogger(EventGenerator.class.getName());

	public enum EventType {
		UPDATE_ALL_TIMES, CLOCK_ADDED, SHOW_GUI
	};

	private Map<Integer, Clock> mapClockIdToClock;

	public EventGenerator() {
		this.mapClockIdToClock = new HashMap<>();
	}

	public ModelEvent<Integer> registerClock(String displayName) {
		Clock clock = new Clock(displayName, 8 * 3600);
		mapClockIdToClock.put(clock.getId(), clock);
		return new ModelEvent<Integer>(EventType.CLOCK_ADDED, clock.getId());
	}

	public List<ModelEvent<?>> getEvents() {
		List<ModelEvent<?>> modelEvents = new ArrayList<>();
		modelEvents.addAll(getUpdateTimeEvent());
		modelEvents.addAll(getScheduledEvents());
		return modelEvents;
	}

	private List<ModelEvent<?>> getScheduledEvents() {
		List<ModelEvent<?>> modelEvents = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		if (hour >= 1 && hour < 6 && (minute % 5) == 0) {
			modelEvents.add(new ModelEvent<Integer>(EventType.SHOW_GUI, 0));
		}
		return modelEvents;
	}

	private List<ModelEvent<?>> getUpdateTimeEvent() {
		List<ModelEvent<?>> modelEvents = new ArrayList<>();
		Map<Integer, ModelResponse> map = new HashMap<>();
		for (Entry<Integer, Clock> entry : mapClockIdToClock.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getModelResponse());
		}
		ModelEvent<Map<Integer, ModelResponse>> me = new ModelEvent<>(EventType.UPDATE_ALL_TIMES, map);
		modelEvents.add(me);
		// logger.log(Level.INFO, "Added Model Event : " + me.getType());
		return modelEvents;
	}

}

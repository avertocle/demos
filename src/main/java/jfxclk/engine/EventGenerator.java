package jfxclk.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import jfxclk.engine.model.Clock;
import jfxclk.engine.model.ModelResponse;

public class EventGenerator {
	
	private static Logger logger = Logger.getLogger(EventGenerator.class.getName());
	
	public enum EventType {UPDATE_ALL_TIMES, CLOCK_ADDED};
	
	private Map<Integer, Clock> mapClockIdToClock;
	
	public EventGenerator() {
		this.mapClockIdToClock = new HashMap<>();
	}
	
	public ModelEvent<Integer> registerClock(String displayName){
		Clock clock = new Clock(displayName, Clock.DEFAULT_TIME_FORMAT);
		mapClockIdToClock.put(clock.getId(), clock);
		return new ModelEvent<Integer>(EventType.CLOCK_ADDED, clock.getId());
	}

	public List<ModelEvent<?>> getEvents(){
		List<ModelEvent<?>> modelEvents = new ArrayList<>();
		Map<Integer, ModelResponse> map = getUpdateTimeEvent();
		if(map != null){
			ModelEvent<Map<Integer, ModelResponse>> me = new ModelEvent<>(EventType.UPDATE_ALL_TIMES, map);
			modelEvents.add(me);
			//logger.log(Level.INFO, "Added Model Event : " + me.getType());
		}
		return modelEvents;
	}
	
	private Map<Integer, ModelResponse> getUpdateTimeEvent(){
		Map<Integer, ModelResponse> map = new HashMap<>();
		for (Entry<Integer, Clock> entry : mapClockIdToClock.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getModelResponse());
		}
		return map;
	}
	

	

}

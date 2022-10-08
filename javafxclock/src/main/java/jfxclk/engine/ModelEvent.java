package jfxclk.engine;

import jfxclk.engine.EventGenerator.EventType;

public class ModelEvent<T> {
	
	private EventType type;
	private T data;
	
	public ModelEvent(EventType type, T data) {
		super();
		this.type = type;
		this.data = data;
	}

	public EventType getType() {
		return type;
	}

	public T getData() {
		return data;
	}
}

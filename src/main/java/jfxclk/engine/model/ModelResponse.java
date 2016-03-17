package jfxclk.engine.model;

public class ModelResponse {

	/** TODO :: Make this automated **/
	
	private String modelName;
	private String time;

	public ModelResponse(String modelName, String time) {
		super();
		this.modelName = modelName;
		this.time = time;
	}
	
	public String getModelName() {
		return modelName;
	}

	public String getTime() {
		return time;
	}
}

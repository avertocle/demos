package jfxclk.engine.view;

import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import jfxclk.engine.model.ModelResponse;

public class MainScene extends Scene {

	private Pane pane;
	private Map<Integer, Label> labels;
	private int labelCount;

	public MainScene(Pane pane, Dimension size) {
		super(pane, size.getWidth(), size.getHeight());
		this.pane = pane;
		makeElements();
		make();
	}

	private void makeElements() {
		labels = new LinkedHashMap<>();
	}
	
	public void registerLabel(){
		
	}

	public void registerLabel(int labelId){
		labelCount++;
		Label label = GuiLibrary.makeTimeLabel();
		labels.put(labelId, label);
		pane.getChildren().add(label);
	}

	private void make() {
	
	}

	public void update(Map<Integer, ModelResponse> modelResponseMap) {
		int labelId;
		for(Entry<Integer, ModelResponse> entry : modelResponseMap.entrySet()){
			labelId = entry.getKey();
			if(labels.containsKey(labelId)) {
				updateForSingleModelResponse(labels.get(labelId), entry.getValue());
			}
		}
	}
	
	private void updateForSingleModelResponse(Label label, ModelResponse modelResponse){
		label.setText(modelResponse.getTime());
	}

}

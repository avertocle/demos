package jfxclk.engine.view;

import java.util.logging.Logger;

import javafx.stage.Stage;

public class StageManager {

	private Logger logger = Logger.getLogger(StageManager.class.getName());

	private Stage primaryStage;

	public StageManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void toggleVisibility() {
		if (primaryStage.isShowing()) {
			logger.info("Hiding Primary Stage");
			primaryStage.hide();
		}
		else {
			logger.info("Showing Primary Stage");
			primaryStage.show();
		}
	}
	
	public void show(){
		primaryStage.show();
	}
	
}

package jfxclk.engine;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxclk.engine.view.MainScene;
import jfxclk.engine.view.UserSettings;

public class Main extends Application {

	private MainController mainController;
	private MainScene mainScene;

	public static void main(String[] args) {
		launch(args);

		/* Safety net, till I know how this internally works. */
		System.exit(0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initialize(primaryStage);
		mainController.start();
	}

	private void initialize(Stage primaryStage) {

		Dimension stageSize = new Dimension(UserSettings.gi().stage.STAGE_WIDTH, UserSettings.gi().stage.STAGE_HIEGHT);
		mainScene = new MainScene(new StackPane(), stageSize);
		initializePrimaryStage(primaryStage, mainScene);

		mainController = new MainController(mainScene);
	}

	private void initializePrimaryStage(Stage primaryStage, MainScene mainScene) {
		primaryStage.setTitle(UserSettings.gi().stage.STAGE_TITLE);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

}

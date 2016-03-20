package jfxclk.engine;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jfxclk.engine.view.MainScene;
import jfxclk.engine.view.StageManager;
import jfxclk.engine.view.SystemTrayIcon;
import jfxclk.engine.view.UserSettings;

public class Main extends Application {

	private MainController mainController;
	private MainScene mainScene;
	private StageManager primaryStageManager;
	private TrayIcon trayIcon;

	public static void main(String[] args) {
		launch(args);

		/* Safety net, till I know how this internally works. */
		System.exit(0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStageManager = new StageManager(primaryStage);
		initialize(primaryStage);
		mainController.start();
	}

	private void initialize(Stage primaryStage) {
		Dimension stageSize = new Dimension(UserSettings.gi().stage.STAGE_WIDTH, UserSettings.gi().stage.STAGE_HIEGHT);
		mainScene = new MainScene(new StackPane(), stageSize);
		initializePrimaryStage(primaryStage, mainScene);
		initializeTrayIcon(primaryStage);
		mainController = new MainController(mainScene, primaryStageManager);
	}

	private void initializePrimaryStage(Stage primaryStage, MainScene mainScene) {
		Platform.setImplicitExit(false);
		primaryStage.setTitle(UserSettings.gi().stage.STAGE_TITLE);
		primaryStage.setScene(mainScene);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				primaryStage.hide();
			}
		});
	}

	private void initializeTrayIcon(Stage primaryStage) {
		trayIcon = SystemTrayIcon.get(new TrayListener());
		try {
			if (SystemTray.isSupported()) {
				SystemTray.getSystemTray().add(trayIcon);
			}
		}
		catch (AWTException e) {
			/* Log this */ }
	}

	class TrayListener implements ActionListener {

		@Override
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					primaryStageManager.toggleVisibility();
				}
			});
		}
	};

}

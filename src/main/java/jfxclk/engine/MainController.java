package jfxclk.engine;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javafx.application.Platform;
import jfxclk.engine.model.ModelResponse;
import jfxclk.engine.view.MainScene;
import jfxclk.engine.view.StageManager;
import jfxclk.engine.view.UserSettings;

public class MainController extends Thread {

	private EventGenerator eventGenerator;
	private MainScene mainScene;
	private StageManager primaryStageManager;

	private boolean runForever = true;

	public MainController(MainScene mainScene, StageManager primaryStageManager) {
		this.mainScene = mainScene;
		this.primaryStageManager = primaryStageManager;
		eventGenerator = new EventGenerator();
	}

	public void terminate() {
		this.runForever = false;
	}

	@Override
	public void run() {
		initialize();
		List<ModelEvent<?>> modelEvents;
		while (runForever) {
			modelEvents = eventGenerator.getEvents();
			parseAllEventsAndUpdateGUI(modelEvents);
			sleepNowOrTerminate();
		}
		performExitTasks();
	}

	/********************************************************************************
	 * Internal Methods
	 ********************************************************************************/

	private <T> void parseAllEventsAndUpdateGUI(List<ModelEvent<?>> modelEvents) {
		for (ModelEvent<?> me : modelEvents) {
			parseEventAndUpdateGUI(me);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> void parseEventAndUpdateGUI(ModelEvent<T> event) {
		switch (event.getType()) {
			case UPDATE_ALL_TIMES:
				Map<Integer, ModelResponse> map = (Map<Integer, ModelResponse>) event.getData();
				runOnUIThread(mainScene::update, map);
				break;
			case CLOCK_ADDED:
				runOnUIThread(mainScene::registerLabel, (Integer) event.getData());
				break;
			case SHOW_GUI:
				runOnUIThread(primaryStageManager::show);
				break;
		}
	}

	private <T> void runOnUIThread(Runnable runnable) {
		Platform.runLater(runnable);
	}

	private <T> void runOnUIThread(Consumer<T> consumer, T consumable) {
		Runnable runnable = () -> consumer.accept(consumable);
		Platform.runLater(runnable);
	}

	private void sleepNowOrTerminate() {
		try {
			sleep(UserSettings.gi().refreshIntervalMilliSeconds);
		}
		catch (InterruptedException e) {
			runForever = false;
		}
	}

	private void performExitTasks() {

	}

	private void initialize() {
		ModelEvent<Integer> me = eventGenerator.registerClock(UserSettings.gi().DEFAULT_CLOCK_NAME);
		parseEventAndUpdateGUI(me);
		ModelEvent<Integer> me2 = eventGenerator.registerClock(UserSettings.gi().DEFAULT_CLOCK_NAME);
		parseEventAndUpdateGUI(me2);
	}

}

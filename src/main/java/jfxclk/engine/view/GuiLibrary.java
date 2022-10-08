package jfxclk.engine.view;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GuiLibrary {
	
	public static Label makeTimeLabel(){
		Label label = new Label("00:00:00");
		label.setFont(new Font(label.getFont().getName(), 300));
		label.setStyle(UserSettings.gi().STYLE_LABEL);
		return label;
	}

}

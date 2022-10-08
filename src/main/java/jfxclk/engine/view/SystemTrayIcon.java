package jfxclk.engine.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javafx.application.Platform;

public class SystemTrayIcon extends TrayIcon {

	public static SystemTrayIcon get(ActionListener actionListener){
		Image image = getTrayIconImage();
		return get(image, actionListener);
	}
	
	public static SystemTrayIcon get(Image image, ActionListener actionListener){
		SystemTrayIcon trayIcon = new SystemTrayIcon(image);
		trayIcon.setToolTip(UserSettings.gi().DEFAULT_CLOCK_NAME);
		
		MenuItem menuItem = trayIcon.makeExitOptionForPopupMenu();
		PopupMenu popupMenu = new PopupMenu();
		popupMenu.add(menuItem);
		trayIcon.setPopupMenu(popupMenu);
		trayIcon.addActionListener(actionListener);
		return trayIcon;
	}
	
	private SystemTrayIcon(Image image) {
		super(image);
	}
	
	private static Image getTrayIconImage() {
		BufferedImage bufferedImage = new BufferedImage(100, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		g.drawString("00:00:00", 0, 0);
		return bufferedImage;
	}

	private MenuItem makeExitOptionForPopupMenu() {
		MenuItem menuItem = new MenuItem("Exit");
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		};
		menuItem.addActionListener(listener);
		return menuItem;
	}


}

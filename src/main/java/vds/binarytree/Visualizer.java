package vds.binarytree;

import javax.swing.JFrame;

import vds.interfaces.DrawableBinaryTree;
import vds.utils.SystemUtils;

public class Visualizer {

	public static void draw(DrawableBinaryTree dbt) {

		JFrame frame = new JFrame();
		PanelMain panelMain = new PanelMain(dbt);
		frame.getContentPane().add(panelMain);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(SystemUtils.getScreenWidth(), SystemUtils.getScreenHeight());
		frame.setVisible(true);
	}

}

package vds.binarytree;

import javax.swing.JFrame;

import vds.interfaces.DrawableBinaryTree;

public class Visualizer {

	public static void draw(DrawableBinaryTree dt) {

		JFrame frame = new JFrame();
		PanelTree panelTree = new PanelTree(dt);
		frame.getContentPane().add(panelTree);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(panelTree.getMaxSizeX(), panelTree.getMaxSizeY());
		frame.setVisible(true);
	}

}

package vds.binarytree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

import vds.interfaces.DrawableBinaryTree;
import vds.utils.TreeUtils;
import vds.utils.GraphicUtils;
import vds.utils.Utils;

public class PanelTree extends JPanel {

	private static final long serialVersionUID = 1L;

	private DrawableBinaryTree dt;
	private int maxSizeX;
	private int maxSizeY;
	private int nodeRadius;

	private List<List<DrawableBinaryTree>> levelOrder;
	private List<List<Point>> grid;

	public PanelTree(DrawableBinaryTree dt) {
		super();
		this.dt = dt;
		setTreeParameters();
	}

	public void refreshTree() {
		setTreeParameters();
	}
	
	public int getMaxSizeX() {
		return maxSizeX;
	}

	public int getMaxSizeY() {
		return maxSizeY;
	}

	/*************************************************************
	 * Methods :: Internal
	 *************************************************************/

	private void setTreeParameters() {
		maxSizeX = 800;
		maxSizeY = 600;
		nodeRadius = 25;
		levelOrder = Utils.levelOrder(dt);
		grid = TreeUtils.getTreeGrid(levelOrder.size(), maxSizeX, 2 * 2 * nodeRadius);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setPaint(Color.blue);
		drawTree(g, this.levelOrder, this.grid);
	}

	private void drawTree(Graphics2D g, List<List<DrawableBinaryTree>> levelOrder, List<List<Point>> grid) {
		int levelCount = levelOrder.size();
		if (levelCount == 0) {
			return;
		}

		List<DrawableBinaryTree> nodes;
		DrawableBinaryTree node;
		Point p, plc, prc;
		for (int i = 0; i < levelOrder.size(); i++) {
			nodes = levelOrder.get(i);
			for (int j = 0; j < nodes.size(); j++) {
				node = nodes.get(j);
				if (node != null) {
					p = grid.get(i).get(j);
					GraphicUtils.drawLabledCircle(g, p, node.getData(), nodeRadius);
					if (node.getLeftChild() != null) {
						plc = grid.get(i + 1).get(2 * j);
						GraphicUtils.drawLineConnectingCircles(g, p, plc, nodeRadius);
					}
					if (node.getRightChild() != null) {
						prc = grid.get(i + 1).get(2 * j + 1);
						GraphicUtils.drawLineConnectingCircles(g, p, prc, nodeRadius);
					}
				}
			}
		}
	}

}

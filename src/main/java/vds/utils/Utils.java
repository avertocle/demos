package vds.utils;

import java.util.ArrayList;
import java.util.List;

import vds.interfaces.DrawableBinaryTree;

public class Utils {

	public static List<List<DrawableBinaryTree>> levelOrder(DrawableBinaryTree root) {
		List<List<DrawableBinaryTree>> results = new ArrayList<>();
		List<DrawableBinaryTree> nextLevelNodes = new ArrayList<DrawableBinaryTree>();
		Utils.addToListIfNotNull(nextLevelNodes, root);
		levelOrder(nextLevelNodes, results);
		return results;
	}

	private static void levelOrder(List<DrawableBinaryTree> nodeList, List<List<DrawableBinaryTree>> results) {
		if (nodeList.isEmpty()) {
			return;
		}
		List<DrawableBinaryTree> result = new ArrayList<>();
		List<DrawableBinaryTree> nextLevelNodes = new ArrayList<DrawableBinaryTree>();
		for (DrawableBinaryTree node : nodeList) {
			if (node != null) {
				result.add(node);
				Utils.addToListIfNotNull(nextLevelNodes, node.getLeftChild());
				Utils.addToListIfNotNull(nextLevelNodes, node.getRightChild());
			}
		}
		results.add(result);
		levelOrder(nextLevelNodes, results);
	}

	public static void displayLevelOrder(List<List<DrawableBinaryTree>> levelOrder) {
		for (List<DrawableBinaryTree> nodes : levelOrder) {
			for (DrawableBinaryTree node : nodes) {
				if (node != null) {
					System.out.print(node.getData());
				}
				else {
					System.out.print("X");
				}
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	public static int pow2(int x) {
		return ((int) (Math.pow(2, x)));
	}

	public static <T> void addToListIfNotNull(List<T> list, T value) {
		if (value != null) {
			list.add(value);
		}
	}

}

package vds.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<DrawableBinaryTree> set = new HashSet<DrawableBinaryTree>(nodeList);
		if (set.isEmpty() || (set.size() == 1 && set.contains(null))) {
			return;
		}
		List<DrawableBinaryTree> result = new ArrayList<>();
		List<DrawableBinaryTree> nextLevelNodes = new ArrayList<DrawableBinaryTree>();
		for (DrawableBinaryTree node : nodeList) {
			result.add(node);
			if (node != null) {
				nextLevelNodes.add(node.getLeftChild());
				nextLevelNodes.add(node.getRightChild());
			}
			else{
				nextLevelNodes.add(null);
				nextLevelNodes.add(null);
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

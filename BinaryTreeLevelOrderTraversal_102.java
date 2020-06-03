import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/

public class BinaryTreeLevelOrderTraversal_102 {
	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	// Constructor
	BinaryTreeLevelOrderTraversal_102() {
		root = null;
	}

	public void insert(int[] data) {
		root = insertData(root, data, 0, data.length);
	}

	// Took it from existing code
	public TreeNode insertData(TreeNode root, int[] data, int start, int size) {

		TreeNode temp = new TreeNode(0);
		int left = 2 * start + 1;
		int right = 2 * start + 2;

		if (left > size && right > size) {
			return null;
		}

		if (root == null) {
			temp.val = data[start];
			root = temp;
		}

		if (root.left == null && root.right == null) {
			if (left < size) {
				root.left = new TreeNode(data[left]);
			}
			if (right < size) {
				root.right = new TreeNode(data[right]);
			}
		}

		insertData(root.left, data, left, size);
		insertData(root.right, data, right, size);

		return root;
	}

	// DFS Solution Method by Parampuneet Singh
	public void printByLevel() {
		List<List<Integer>> numArray = new ArrayList<List<Integer>>();
		// Recursive Method
		numArray = printTreeRecursive(root, 0, numArray);
		// Iterative Method
		printTreeIterative(root, 0, numArray);
	}

	// BFS
	public void printTreeIterative(TreeNode root, int treeDepth, List<List<Integer>> numArray) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();
		List<List<Integer>> resp = new ArrayList<List<Integer>>();

		queue.add(root);
		depth.add(0);
		while (queue.size() > 0) {
			TreeNode temp = queue.poll();
			int level = depth.poll();

			int tempVal = temp.val;
			if (resp.size() <= level) {
				resp.add(level, new ArrayList<Integer>());
			}
			resp.get(level).add(tempVal);

			if (temp.left != null) {
				queue.add(temp.left);
				depth.add(level + 1);
			}
			if (temp.right != null) {
				queue.add(temp.right);
				depth.add(level + 1);
			}
		}

		for (int i = 0; i < resp.size(); i++) {
			List<Integer> temp = resp.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.println(temp.get(j));
			}
		}
		/*
		 * //First Solution int count = 0; while(true) { if (queue.size() == 0) { break;
		 * }
		 * 
		 * count = queue.size(); while (count > 0) { TreeNode temp = queue.peek();
		 * System.out.println(temp.val); queue.remove(); if (temp.left != null) {
		 * queue.add(temp.left); } if (temp.right != null) { queue.add(temp.right); }
		 * count--; } }
		 */
	}

	// Solution Method by Parampuneet Singh
	public List<List<Integer>> printTreeRecursive(TreeNode root, int treeDepth, List<List<Integer>> numArray) {

		if (root == null) {
			return null;
		}

		if (treeDepth >= numArray.size()) {
			numArray.add(treeDepth, new ArrayList<Integer>());
		}

		numArray.get(treeDepth).add(root.val);

		if (root.left != null) {
			printTreeRecursive(root.left, treeDepth + 1, numArray);
		}

		if (root.right != null) {
			printTreeRecursive(root.right, treeDepth + 1, numArray);
		}

		return numArray;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_102 tree = new BinaryTreeLevelOrderTraversal_102();
		int data[] = { 1, 2, 3, 4, 5, 6, 7 };
		tree.insert(data);
		tree.printByLevel();
		
		String s = "0:start:0";
		System.out.println(s.split(":")[2]);

		/*
		 * 		1 
		 * 	   / \ 
		 * 	  2   3 
		 * 	 / \ / \ 
		 * 	4  5 6  7
		 */

	}

}

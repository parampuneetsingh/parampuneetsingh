import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/

public class MaximumWidthofBinaryTree_662 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int max = 0, left = 0, right = 0;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<>();
		depth.add(0);
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				int index = depth.poll();
				
				if (i == 0) {
					left = index;
				}

				if (i == size - 1) {
					right = index;
				}

				if (temp.left != null) {
					q.add(temp.left);
					depth.add(2 * index);
				}
				if (temp.right != null) {
					q.add(temp.right);
					depth.add(2 * index + 1);
				}
			}
			max = Math.max(max, right - left + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		MaximumWidthofBinaryTree_662 tree = new MaximumWidthofBinaryTree_662();
		/*
		root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		*/
		root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(7);
		System.out.println(tree.widthOfBinaryTree(root));
	}

}

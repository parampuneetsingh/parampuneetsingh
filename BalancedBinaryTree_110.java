import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/balanced-binary-tree/discuss/290381/Fast-Java-Solution

public class BalancedBinaryTree_110 {

	TreeNode root;

	int leftCount;
	int rightCount;

	public void checkTree() {
		isBalancedBFS(root);
	}

	public int checkDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();

		int max = 0;

		q.add(root);
		depth.add(1);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int d = depth.poll();

			max = Math.max(max, d);

			if (node.left != null) {
				q.add(node.left);
				depth.add(d + 1);
			}

			if (node.right != null) {
				q.add(node.right);
				depth.add(d + 1);
			}
		}

		return max;
	}

	// BFS
	public boolean isBalancedBFS(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int leftDepth = checkDepth(node.left);
			int rightDepth = checkDepth(node.right);

			if (Math.abs(leftDepth - rightDepth) > 1) {
				return false;
			}

			if (node.left != null) {
				q.add(node.left);
			}

			if (node.right != null) {
				q.add(node.right);
			}
		}

		return true;
	}

	//DFS
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBalanced(root.left) && isBalanced(root.right)
				&& Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1;
	}

	private int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree_110 tree = new BalancedBinaryTree_110();
		tree.root = new TreeNode(1);
		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(2);
		/*
		 * tree.root.left = new TreeNode(2); tree.root.right = new TreeNode(2);
		 * tree.root.left.left = new TreeNode(3); tree.root.left.right = new
		 * TreeNode(3); tree.root.left.left.left = new TreeNode(4);
		 * tree.root.left.left.right = new TreeNode(4);
		 */
		tree.checkTree();
	}

}

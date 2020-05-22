import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

public class CheckCompletenessofaBinaryTree_958 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty() && q.peek() != null) {
			TreeNode t = q.poll();

			q.add(t.left);
			q.add(t.right);
		}

		while (!q.isEmpty() && q.peek() == null) {
			q.poll();
		}

		return q.isEmpty();
	}

	public static void main(String[] args) {
		CheckCompletenessofaBinaryTree_958 tree = new CheckCompletenessofaBinaryTree_958();
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(tree.isCompleteTree(root));
	}

}

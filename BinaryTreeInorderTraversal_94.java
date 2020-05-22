import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> lst = new ArrayList<Integer>();
		Stack<TreeNode> stk = new Stack<TreeNode>();

		TreeNode current = root;

		while (!stk.isEmpty() || current != null) {
			while (current != null) {
				stk.push(current);
				current = current.left;
			}

			current = stk.pop();
			lst.add(current.val);
			current = current.right;
		}

		return lst;
	}

	public static void main(String[] args) {
		BinaryTreeInorderTraversal_94 tree = new BinaryTreeInorderTraversal_94();
		root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		tree.inorderTraversal(root);
	}

}

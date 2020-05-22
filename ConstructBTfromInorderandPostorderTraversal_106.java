import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class ConstructBTfromInorderandPostorderTraversal_106 {

	TreeNode root;

	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}

		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		int pLength = postorder.length - 1;
		int iLength = inorder.length - 1;
		TreeNode root = new TreeNode(postorder[pLength]);
		TreeNode parent = null;
		stack.push(root);

		for (int i = iLength, j = pLength - 1; j >= 0; j--) {
			TreeNode current = new TreeNode(postorder[j]);

			while (!stack.isEmpty() && stack.peek().val == inorder[i]) {
				parent = stack.pop();
				i--;
			}
			if (parent != null) {
				parent.left = current;
				parent = null;
			} else {
				stack.peek().right = current;
			}
			stack.push(current);
		}
		return root;
	}

	public static void main(String[] args) {
		ConstructBTfromInorderandPostorderTraversal_106 tree = new ConstructBTfromInorderandPostorderTraversal_106();
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		tree.buildTree(inorder, postorder);
	}

}

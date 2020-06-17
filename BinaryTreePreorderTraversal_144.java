import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/

public class BinaryTreePreorderTraversal_144 {

	static TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
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

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();

		s.push(root);

		while (!s.isEmpty()) {
			TreeNode curr = s.pop();
			list.add(curr.val);

			if (curr.right != null) {
				s.push(curr.right);
			}

			if (curr.left != null) {
				s.push(curr.left);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal_144 tree = new BinaryTreePreorderTraversal_144();
		int data[] = { 1, 2, 3, 4, 5, 6, 7 };
		tree.insert(data);
		System.out.println(tree.preorderTraversal(root));
	}

}

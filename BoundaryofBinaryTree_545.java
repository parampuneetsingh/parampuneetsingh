import java.util.ArrayList;
import java.util.List;

//https://www.lintcode.com/problem/boundary-of-binary-tree/description

public class BoundaryofBinaryTree_545 {

	static TreeNode root;

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

	public void insert(int[] data) {
		root = insertData(root, data, 0, data.length);
	}

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

	public void findLeaves(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}

		findLeaves(root.left, list);
		findLeaves(root.right, list);
	}

	public void findLeftBoundary(TreeNode root, List<Integer> list) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		list.add(root.val);
		if (root.left != null) {
			findLeftBoundary(root.left, list);
		} else if (root.right != null) {
			findLeftBoundary(root.right, list);
		}
	}

	public void findRightBoundary(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		if (root.right != null) {
			findRightBoundary(root.right, list);
			list.add(root.val);
		} else if (root.left != null) {
			findRightBoundary(root.left, list);
			list.add(root.val);
		}
	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return null;
		}

		list.add(root.val);

		findLeftBoundary(root.left, list);
		findLeaves(root, list);
		findRightBoundary(root.right, list);

		return list;
	}

	public static void main(String[] args) {
		int[] data = { 3, 9, 20, 12, 34, 15, 7 };
		BoundaryofBinaryTree_545 traverseTree = new BoundaryofBinaryTree_545();
		traverseTree.insert(data);
		traverseTree.boundaryOfBinaryTree(root);
	}

}

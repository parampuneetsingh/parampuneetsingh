import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

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

	public void invert() {
		invertTree(root);
	}

	// Recursive
	public TreeNode invertTreeRecursive(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	// BFS
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (q.size() > 0) {
			TreeNode current = q.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;

			if (current.left != null) {
				q.add(current.left);
			}

			if (current.right != null) {
				q.add(current.right);
			}
		}
		return root;
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

	public static void main(String[] args) {
		InvertBinaryTree_226 tree = new InvertBinaryTree_226();
		int data[] = { 4, 2, 7, 1, 3, 6, 9 };
		tree.insert(data);
		tree.invert();
	}

}

//https://leetcode.com/problems/delete-node-in-a-bst/

public class DeleteNodeinaBST_450 {

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

	public void deleteTargetNode(int k) {
		deleteNode(root, k);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				TreeNode node = root.right;
				while (node.left != null) {
					node = node.left;
				}
				// move the left child of key node to node.left;
				node.left = root.left;
				// return root.right
				return root.right;
			}
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			root.right = deleteNode(root.right, key);
		}

		return root;
	}

	public static void main(String[] args) {
		int[] data = { 5, 3, 7, 2, 4, 6, 8, 1 };
		DeleteNodeinaBST_450 delete = new DeleteNodeinaBST_450();
		delete.insert(data);
		delete.deleteTargetNode(3);
	}

}

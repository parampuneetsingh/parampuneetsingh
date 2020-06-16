//https://www.lintcode.com/problem/closest-binary-search-tree-value/
//https://www.youtube.com/watch?v=-i67-JS-LFI

public class ClosestBinarySearchTreeValue_270 {

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

	//Faster Solution
	//TimeComplexity O(logN) because we are going either left or Right. Space Complexity O(1) because of Iterative approach
	public static int closestValue(TreeNode root, double target) {

		int res = root.val;

		while (root != null) {
			if (Math.abs(target - root.val) < Math.abs(target - res)) {
				res = root.val;
			}
			if (target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] data = { 2, 1, 3 };
		double target = 5.571429;
		ClosestBinarySearchTreeValue_270 findMinTree = new ClosestBinarySearchTreeValue_270();
		findMinTree.insert(data);
		//closestValue2 soln is better than closestValue1
		System.out.println(closestValue(root, target));
	}

}

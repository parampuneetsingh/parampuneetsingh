import java.util.LinkedList;
import java.util.List;

//https://www.lintcode.com/problem/closest-binary-search-tree-value-ii/description
//https://www.youtube.com/watch?v=3GN3DaJv9_g

public class ClosestBinarySearchTreeValueII_272 {

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

	public static void findMin(TreeNode root, LinkedList<Integer> list, int target, int k) {
		if (root == null) {
			return;
		}

		findMin(root.left, list, (int) Math.round(target), k);
		if (list.size() == k) {
			if (Math.abs(target - root.val) < Math.abs(target - list.peek())) {
				list.remove();
			} else {
				return;
			}
		}
		list.add(root.val);
		findMin(root.right, list, (int) Math.round(target), k);

	}

	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		findMin(root, list, (int) Math.round(target), k);

		return list;
	}

	public static void main(String[] args) {
		int[] data = { 2, 1, 3 };
		double target = 5.571429;
		int k = 2;
		ClosestBinarySearchTreeValueII_272 findMinTree = new ClosestBinarySearchTreeValueII_272();
		findMinTree.insert(data);
		System.out.println(closestKValues(root, target, k));
	}

}

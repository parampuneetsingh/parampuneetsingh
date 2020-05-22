//https://www.youtube.com/watch?v=23oR5ipWwk8

public class CheckIfStringIsValidSequencefromRoottoLeavesinBT {

	int max = 0;

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

	public void checkLeafs(TreeNode root, int[] arr, int n) {
		if (root == null || root.val != arr[n] || (n == arr.length - 1 && (root.left != null || root.right != null))) {
			return;
		}

		if (root.val == arr[n]) {
			n++;
		}

		checkLeafs(root.left, arr, n);
		checkLeafs(root.right, arr, n);

		if (root.left == null && root.right == null && n == arr.length) {
			max = n;
		}
	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		if (root == null || root.val != arr[0]) {
			return false;
		}

		checkLeafs(root, arr, 0);

		return max == arr.length;

	}

	public static void main(String[] args) {
		CheckIfStringIsValidSequencefromRoottoLeavesinBT check = new CheckIfStringIsValidSequencefromRoottoLeavesinBT();
		int[] data = { 0, 1, 0, 0, 1, 0, 1, 1, 0 };
		int[] arr = { 0, 1, 0, 1 };
		check.insert(data);
		System.out.println(check.isValidSequence(root, arr));

	}

}

//https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class SumRootToLeafNumbers_129 {

	TreeNode root;
	int sum = 0;

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

	public int sumNums() {
		return sumNumbers(root);
	}

	public void findSum(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}

		sb.append(root.val);

		if (root.left == null && root.right == null) {
			sum += Integer.parseInt(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return;
		}

		findSum(root.left, sb);
		findSum(root.right, sb);

		sb.deleteCharAt(sb.length() - 1);
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		findSum(root, sb);

		return sum;
	}

	public static void main(String[] args) {
		SumRootToLeafNumbers_129 sum = new SumRootToLeafNumbers_129();
		int[] data = { 4, 9, 0, 5, 1 };
		sum.insert(data);
		System.out.println(sum.sumNums());
	}

}

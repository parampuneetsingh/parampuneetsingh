public class DiameterOfBinaryTree_543 {

	int max = 0;
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

	public int findDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = findDiameter(root.left);
		int right = findDiameter(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}

	//With Global Variable
	public int diameterOfBinaryTree2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		findDiameter(root);
		return max;
	}
	
	public int findDiameter(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		int left = findDiameter(root.left, max);
		int right = findDiameter(root.right, max);

		max[0] = Math.max(max[0], left + right);

		return Math.max(left, right) + 1;
	}

	//Without Global Variable
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] max = new int[1];
		
		findDiameter(root, max);
		return max[0];
	}
	
	public void traverse() {
		diameterOfBinaryTree(root);
	}

	public static void main(String[] args) {
		int[] data = { 1,2,3,4,5 };
		DiameterOfBinaryTree_543 traverseTree = new DiameterOfBinaryTree_543();
		traverseTree.insert(data);
		traverseTree.traverse();

	}

}

public class MaxDepthBinaryTree_104 {

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

	public void findMaxDepth() {
		//Solution1
		//int depth = maxDepth(root, 1);
		//Solution2
		int depth = findDepth(root, 0);
		System.out.println(depth);
	}
	
	//Solution2
	 public int findDepth(TreeNode root, int depth) {
	        if (root == null) {
	            return depth;
	        }
	        
	        int left = findDepth(root.left, depth+1);
	        int right = findDepth(root.right, depth+1);
	        
	        return Math.max(left, right);
	    }
	 
	 //Solution1
	public int maxDepth(TreeNode root, int depth) {
		int result = depth;
		if (root == null) {
			return 0;
		}
		if (root.left != null || root.right != null) {
			result = Math.max(maxDepth(root.left, depth+1), maxDepth(root.right, depth+1));
		}
		return result;
	}

	public static void main(String[] args) {
		MaxDepthBinaryTree_104 tree = new MaxDepthBinaryTree_104();
		//int[] data = {3,9,20,2,4,15,7,8,14};
		int[] data = {1,2,3,4,5};
		tree.insert(data);
		tree.findMaxDepth();
	}

}

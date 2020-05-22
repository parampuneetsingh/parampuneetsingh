//https://leetcode.com/problems/path-sum-iii/
public class PathSumIII_437 {

	static TreeNode root;

	int total = 0;

	public void recurTree(TreeNode root, int sum, int currentSum) {
		if (root != null) {

			currentSum += root.val;
			if (currentSum == sum) {
				total++;
			}

			recurTree(root.left, sum, currentSum);
			recurTree(root.right, sum, currentSum);
		}
	}

	//Solution 2
	public int pathSum2(TreeNode root, int sum) {
		if (root != null) {
			recurTree(root, sum, 0);
			pathSum(root.left, sum);
			pathSum(root.right, sum);
		}

		return total;
	}

	private int countPath(TreeNode root, int target) {
		int count = 0;
		if (root == null) {
			return count;
		}
		if (root.val == target) {
			count++;
		}

		count += countPath(root.left, target - root.val);
		count += countPath(root.right, target - root.val);
		return count;
	}

	// Solution1
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public static void main(String[] args) {
		PathSumIII_437 tree = new PathSumIII_437();
		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		System.out.println(tree.pathSum(root, 8));
	}

}

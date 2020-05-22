import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/

public class PathSumII_113 {

	TreeNode root;

	public void findLists(TreeNode root, int sum, int total, List<Integer> subList, List<List<Integer>> res) {
		if (root == null) {
			return;
		}

		total += root.val;

		if (root.left == null && root.right == null && (total == sum)) {
			subList.add(root.val);
			res.add(new ArrayList<>(subList));
			subList.remove(subList.size() - 1);
			return;
		}

		subList.add(root.val);
		findLists(root.left, sum, total, subList, res);
		findLists(root.right, sum, total, subList, res);
		subList.remove(subList.size() - 1);
	}

	public List<List<Integer>> findSum(int sum) {
		return pathSum(root, sum);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();

		findLists(root, sum, 0, subList, res);

		return res;
	}

	public static void main(String[] args) {
		PathSumII_113 tree = new PathSumII_113();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(8);
		tree.root.left.left = new TreeNode(11);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.right.left = new TreeNode(5);
		tree.root.right.right.right = new TreeNode(1);
		tree.findSum(22);
	}

}

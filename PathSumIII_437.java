import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-iii/
public class PathSumIII_437 {

	static TreeNode root;

	int total = 0;

	List<Integer> list = new ArrayList<Integer>();

	private int countPath2(TreeNode root, int target) {
		int count = 0;
		if (root == null) {
			return count;
		}
		if (root.val == target) {
			count++;
		}

		count += countPath2(root.left, target - root.val);
		count += countPath2(root.right, target - root.val);
		return count;
	}

	// Solution1 - O(n^2)
	public int pathSum2(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		return countPath2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
	}

	public void countPath(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		list.add(root.val);
		countPath(root.left, sum);
		countPath(root.right, sum);

		int t = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			t += list.get(i);
			if (t == sum) {
				total++;
			}
		}

		list.remove(list.size() - 1);
	}

	// Solution1 - O(n)
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		countPath(root, sum);
		return total;
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

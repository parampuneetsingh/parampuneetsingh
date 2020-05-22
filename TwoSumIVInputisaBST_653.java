import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class TwoSumIVInputisaBST_653 {

	TreeNode root;

	public boolean findNum(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null) {
			return false;
		}

		int t = k - root.val;
		if (set.contains(t)) {
			return true;
		}

		set.add(root.val);

		boolean left = findNum(root.left, k, set);
		boolean right = findNum(root.right, k, set);

		return left || right;
	}

	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<Integer>();

		return findNum(root, k, set);
	}

	public void findNum(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		findNum(root.left, list);
		list.add(root.val);
		findNum(root.right, list);
	}

	// Better Solution
	public boolean findTarget2(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();

		findNum(root, list);

		int low = 0, high = list.size() - 1;

		while (low < high) {
			int t = list.get(low) + list.get(high);
			if (t == k) {
				return true;
			} else if (t < k) {
				low++;
			} else {
				high--;
			}
		}

		return false;
	}

	public boolean find(int k) {
		// find Target2 faster and Better Solution
		return findTarget2(root, k);
		// return findTarget(root, k);
	}

	public static void main(String[] args) {
		TwoSumIVInputisaBST_653 tree = new TwoSumIVInputisaBST_653();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.right = new TreeNode(7);
		System.out.println(tree.find(9));
	}

}

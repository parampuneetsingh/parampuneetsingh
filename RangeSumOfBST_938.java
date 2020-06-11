import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumOfBST_938 {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

		        /*10
		        /  \
		       5    15
		      / \    \
		     3	 7    18*/
	
	public int iterativeBST(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}

		int ans = 0;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.val >= L && node.val <= R) {
				ans += node.val;
			}

			if (node.left != null && node.val >= L) {
				q.offer(node.left);
			}

			if (node.right != null && node.val <= R) {
				q.offer(node.right);
			}
		}

		return ans;
	}

	public int calcBST(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}

		int resp = 0;

		if (root.val >= L && root.val <= R) {
			resp += root.val;
		}

		if (root.val >= L) {
			resp += calcBST(root.left, L, R);
		}

		if (root.val <= R) {
			resp += calcBST(root.right, L, R);
		}

		return resp;
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) {
			return -1;
		}

		// Recursive
		// return calcBST(root, L, R);

		// Iterative
		return iterativeBST(root, L, R);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

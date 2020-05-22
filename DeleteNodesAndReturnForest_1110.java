import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/delete-nodes-and-return-forest/
//https://www.youtube.com/watch?v=ZwlVb_sz-dE

public class DeleteNodesAndReturnForest_1110 {

	TreeNode root;
	private List<TreeNode> ans = new ArrayList();

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

	// DFS
	public void helper(TreeNode root, Set<Integer> set, int d) {
		if (root == null) {
			return;
		}
		if (set.contains(root.val)) {
			helper(root.left, set, 0);
			helper(root.right, set, 0);
		} else {
			helper(root.left, set, d + 1);
			helper(root.right, set, d + 1);
			
			if (root.left != null && set.contains(root.left.val)) {
				root.left = null;
			}
			
			if (root.right != null && set.contains(root.right.val)) {
				root.right = null;
			}
			
			if (d == 0) {
				ans.add(root);
			}
		}
	}

	public List<TreeNode> delNodesDFS(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : to_delete) {
			set.add(i);
		}
		helper(root, set, 0);
		return ans;
	}

	public List<TreeNode> returnForest(int[] to_delete) {

		return delNodesBFS(root, to_delete);
		// return delNodesDFS(root, to_delete);
	}

	// BFS
	public List<TreeNode> delNodesBFS(TreeNode root, int[] to_delete) {
		List<TreeNode> resp = new ArrayList<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Set<Integer> set = new HashSet<Integer>();

		for (int i : to_delete) {
			set.add(i);
		}

		q.add(root);
		resp.add(root);

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();

			if (set.contains(curr.val)) {
				resp.remove(curr);

				if (curr.left != null) {
					resp.add(curr.left);
				}
				if (curr.right != null) {
					resp.add(curr.right);
				}
			}

			if (curr.left != null) {
				q.add(curr.left);

				if (set.contains(curr.left.val)) {
					curr.left = null;
				}
			}

			if (curr.right != null) {
				q.add(curr.right);

				if (set.contains(curr.right.val)) {
					curr.right = null;
				}
			}
		}
		return resp;
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7 };
		int[] to_delete = { 3, 5 };
		DeleteNodesAndReturnForest_1110 delNodes = new DeleteNodesAndReturnForest_1110();
		delNodes.insert(data);
		delNodes.returnForest(to_delete);
	}

}

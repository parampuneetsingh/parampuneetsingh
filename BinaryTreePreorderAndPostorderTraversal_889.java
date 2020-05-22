import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreePreorderAndPostorderTraversal_889 {

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

	int i = 0, j = 0;

	// DFS
	public TreeNode constructFromPrePostDFS(int[] pre, int[] post) {
		TreeNode node = new TreeNode(pre[i++]);
		if (node.val != post[j]) {
			node.left = constructFromPrePostDFS(pre, post);
		}
		if (node.val != post[j]) {
			node.right = constructFromPrePostDFS(pre, post);
		}
		j++;
		return node;
	}

	// BFS
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		TreeNode root = new TreeNode(pre[0]);
		Deque<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		for (int i = 1, j = 0; i < pre.length; i++) {
			TreeNode node = new TreeNode(pre[i]);
			while (q.getLast().val == post[j]) {
				q.pollLast();
				j++;
			}
			if (q.getLast().left == null) {
				q.getLast().left = node;
			} else {
				q.getLast().right = node;
			}
			q.offer(node);
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreePreorderAndPostorderTraversal_889 tree = new BinaryTreePreorderAndPostorderTraversal_889();
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 }, post = { 4, 5, 2, 6, 7, 3, 1 };
		tree.constructFromPrePost(pre, post);
		tree.constructFromPrePostDFS(pre, post);
	}

}

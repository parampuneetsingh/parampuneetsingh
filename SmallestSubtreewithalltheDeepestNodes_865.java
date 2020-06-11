import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes

public class SmallestSubtreewithalltheDeepestNodes_865 {

	TreeNode root;

	class Node {
		TreeNode node;
		int height;

		public Node(TreeNode node, int height) {
			this.node = node;
			this.height = height;
		}
	}

	// Solution 1
	public TreeNode subtreeWithAllDeepestDFS(TreeNode root) {
		if (root == null) {
			return null;
		}

		Node ans = postOrder(root, 0);
		return ans.node;
	}

	private Node postOrder(TreeNode root, int height) {
		if (root == null) {
			return null;
		}

		Node left = postOrder(root.left, height + 1);
		Node right = postOrder(root.right, height + 1);

		// Leaf node
		if (left == null && right == null) {
			return new Node(root, height);
		}

		// One sided, return non null
		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		// When both are not null, return Node with larger height
		return left.height == right.height ? new Node(root, left.height) : left.height > right.height ? left : right;
	}

	// Solution 2
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return null;
		}

		int maxDepth = -1;
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

		populateMap(root, map);

		for (int i : map.values()) {
			maxDepth = Math.max(maxDepth, i);
		}

		return resultNode(root, maxDepth, map);
	}

	public TreeNode resultNode(TreeNode root, int maxDepth, Map<TreeNode, Integer> map) {

		if (root == null) {
			return null;
		}

		if (map.get(root) == maxDepth) {
			return root;
		}

		TreeNode left = resultNode(root.left, maxDepth, map);
		TreeNode right = resultNode(root.right, maxDepth, map);

		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		if (right != null)
			return right;

		return null;
	}

	public void populateMap(TreeNode root, Map<TreeNode, Integer> map) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();

		q.add(root);
		depth.add(0);

		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			int d = depth.poll();

			map.put(t, d);

			if (t.left != null) {
				q.add(t.left);
				depth.add(d + 1);
			}

			if (t.right != null) {
				q.add(t.right);
				depth.add(d + 1);
			}
		}
	}

	public void findDeepest() {
		subtreeWithAllDeepestDFS(root);
		// subtreeWithAllDeepest(root);
	}

	public static void main(String[] args) {
		SmallestSubtreewithalltheDeepestNodes_865 tree = new SmallestSubtreewithalltheDeepestNodes_865();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(1);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
		tree.findDeepest();
	}

}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

//https://www.lintcode.com/problem/binary-tree-vertical-order-traversal/

public class BinaryTreeVerticalOrderTraversal_314 {

	static TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
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

	public List<List<Integer>> verticalOrder(TreeNode root) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		List<List<Integer>> resp = new ArrayList<List<Integer>>();

		if (root == null) {
			return resp;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> depth = new LinkedList<Integer>();

		q.add(root);
		depth.add(0);

		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			int d = depth.poll();

			map.putIfAbsent(d, new ArrayList<Integer>());
			map.get(d).add(curr.val);

			if (curr.left != null) {
				q.add(curr.left);
				depth.add(d - 1);
			}

			if (curr.right != null) {
				q.add(curr.right);
				depth.add(d + 1);
			}
		}

		resp.addAll(map.values());

		return resp;
	}

	private void findVerticalNodes(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map, int depth) {
		if (root == null) {
			return;
		}

		map.putIfAbsent(depth, new ArrayList<Integer>());
		map.get(depth).add(root.val);
		findVerticalNodes(root.left, map, depth - 1);
		findVerticalNodes(root.right, map, depth + 1);
	}

	//DFS Solution - Not passing all test cases
	public List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> resp = new ArrayList<List<Integer>>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		findVerticalNodes(root, map, 0);

		resp.addAll(map.values());

		return resp;
	}

	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal_314 tree = new BinaryTreeVerticalOrderTraversal_314();
		int data[] = { 1, 2, 3, 4, 5, 6, 7 };
		tree.insert(data);
		System.out.println(tree.verticalOrder2(root));
	}

}

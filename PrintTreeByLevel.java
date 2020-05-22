import java.util.ArrayList;
import java.util.List;

public class PrintTreeByLevel {

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

	public PrintTreeByLevel() {
		root = null;
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

	public void printByLevel() {
		printByLevel(root);
	}

	public List<List<Integer>> addToList(TreeNode root, List<List<Integer>> res, int level) {
		if (level >= res.size()) {
			res.add(level, new ArrayList<Integer>());
		}
		
		res.get(level).add(root.val);
		
		if (root.left != null) {
			addToList(root.left, res, level + 1);
		}
		
		if (root.right != null) {
			addToList(root.right, res, level + 1);
		}
		
		return res;
	}

	public List<List<Integer>> printByLevel(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		res = addToList(root, res, 0); // With if Recursive Call

		return res;
	}

	public static void main(String[] args) {
		int[] data = { 3, 9, 20, 15, 7 };
		PrintTreeByLevel printTree = new PrintTreeByLevel();
		printTree.insert(data);
		printTree.printByLevel();
	}

}

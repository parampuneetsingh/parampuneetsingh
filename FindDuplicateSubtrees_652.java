import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees_652 {

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public String addToList(TreeNode root, List<TreeNode> res) {
		if (root == null) {
			return null;
		}

		String s = root.val + "," + addToList(root.left, res) + "," + addToList(root.right, res);
		map.put(s, map.getOrDefault(s, 0) + 1);

		if (map.get(s) == 2) {
			res.add(root);
		}

		return s;
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();

		addToList(root, res);

		return res;
	}

	public static void main(String[] args) {
		FindDuplicateSubtrees_652 tree = new FindDuplicateSubtrees_652();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.right.left = new TreeNode(2);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.left.left = new TreeNode(4);
		List<TreeNode> res = tree.findDuplicateSubtrees(root);
		System.out.println(res.toString());
	}

}

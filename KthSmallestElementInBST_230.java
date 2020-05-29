import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST_230 {

	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}

		dfs(root.left);
		val--;
		if (val == 0) {
			min_val = root.val;
			return;
		}
		dfs(root.right);
	}

	// Solution 2 - Best Solution
	 public int kthSmallest2(TreeNode root, int k) {
	        Deque<TreeNode> stack = new LinkedList<TreeNode>();
	        
	        while(true) {
	            while(root != null) {
	                stack.add(root);
	                root = root.left;
	            }
	            root = stack.removeLast();
	            if (--k == 0) {
	                return root.val;
	            }
	            root = root.right;
	        }
	    }

	// Solution 1
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}

		List<Integer> res = new ArrayList<Integer>();
		inOrder(root, res);

		if (k > 0 && res.size() >= k) {
			return res.get(k - 1);
		}

		return 0;
	}

	public static void main(String[] args) {
		KthSmallestElementInBST_230 tree = new KthSmallestElementInBST_230();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(2);
		System.out.println(tree.kthSmallest2(root, 1));
	}

}

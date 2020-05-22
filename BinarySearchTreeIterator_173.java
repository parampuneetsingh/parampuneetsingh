import java.util.LinkedList;

//https://leetcode.com/problems/binary-search-tree-iterator/

public class BinarySearchTreeIterator_173 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	LinkedList<Integer> treeList;

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			inOrder(root.left);
		}
		treeList.add(root.val);

		if (root.right != null) {
			inOrder(root.right);
		}
	}

	public BinarySearchTreeIterator_173(TreeNode root) {
        treeList = new LinkedList<Integer>();
        inOrder(root);
    }

	/** @return the next smallest number */
	public int next() {
		return treeList.poll();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !treeList.isEmpty();
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/

public class BinarySearchTreeIteratorWithStack_173 {

	Stack<TreeNode> stack;

	public BinarySearchTreeIteratorWithStack_173(TreeNode root) {
		stack = new Stack<TreeNode>();
		pushLeft(root);
	}

	public void pushLeft(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curr = stack.pop();

		if (curr.right != null) {
			pushLeft(curr.right);
		}

		return curr.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//https://leetcode.com/problems/binary-tree-right-side-view/
//https://www.youtube.com/watch?v=eBdKNoW3VJg

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

	Node root;

	public void treeView() {
		rightSideView(root);
	}

	// Solution 2
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root == null) {
			return list;
		}

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();

				if (i == 0) {
					list.add(t.val);
				}

				if (t.right != null) {
					q.add(t.right);
				}
				if (t.left != null) {
					q.add(t.left);
				}
			}
		}
		return list;
	}

	// Solution 1
	public List<Integer> rightSideView(Node root) {
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		helper(root, lst, 0);
		lst.add(lst.size(), new ArrayList<Integer>());
		for (int i = 0; i < lst.size() - 1; i++) {
			lst.get(lst.size() - 1).add(lst.get(i).get(0));
		}
		return lst.get(lst.size() - 1);
	}

	public void helper(Node root, List<List<Integer>> lst, int size) {
		if (root == null) {
			return;
		}
		if (lst.size() <= size) {
			lst.add(size, new ArrayList<Integer>());
		}
		lst.get(size).add(root.val);
		helper(root.right, lst, size + 1);
		helper(root.left, lst, size + 1);
	}

	public static void main(String[] args) {
		BinaryTreeRightSideView_199 tree = new BinaryTreeRightSideView_199();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(4);
		tree.treeView();
	}

}

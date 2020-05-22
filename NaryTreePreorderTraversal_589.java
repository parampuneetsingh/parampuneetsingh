//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//https://www.youtube.com/watch?v=HOMjIiztImo

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal_589 {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<Node> stk = new Stack<Node>();

		stk.push(root);

		while (!stk.isEmpty()) {
			Node n = stk.pop();

			list.add(n.val);
			for (int i = n.children.size() - 1; i >= 0; i--) {
				stk.push(n.children.get(i));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

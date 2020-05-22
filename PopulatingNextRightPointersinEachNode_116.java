import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class PopulatingNextRightPointersinEachNode_116 {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	public Node connect(Node root) {
		Node n = root;
		Queue<Node> q = new LinkedList<Node>();

		q.add(n);
		q.add(null);

		while (q.peek() != null) {
			int size = q.size() - 1;

			while (size-- > 0) {
				Node t = q.poll();
				t.next = q.peek();

				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}
			}
			q.remove();
			q.add(null);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

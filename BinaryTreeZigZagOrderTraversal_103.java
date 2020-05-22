import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

class Node {
	int val;
	Node left, right;

	public Node(int val) {
		this.val = val;
		left = right = null;
	}
}

public class BinaryTreeZigZagOrderTraversal_103 {

	Node root;

	public void printZigZag() {
		//zigzagLevelOrder(root);
		zigzagLevelOrder2(root);
	}

	public List<List<Integer>> 	zigzagLevelOrder2(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		
		q1.add(root);
		q2.add(0);
		
		while(!q1.isEmpty()) {
			Node temp = q1.poll();
			int level = q2.poll(); 
			
			if (list.size() <= level) {
				list.add(level, new ArrayList<Integer>());
			}
			
			list.get(level).add(temp.val);
			
			if (temp.left != null) {
				q1.add(temp.left);
				q2.add(level + 1);
			}
			if (temp.right!= null) {
				q1.add(temp.right);
				q2.add(level + 1);
			}
			
		}
		
		for (int i=1; i < list.size(); i=i+2) {
			Collections.reverse(list.get(i));
		}
		
		return list;
	}
	
	// BFS solution
	public List<List<Integer>> zigzagLevelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			Queue<Node> temp = new LinkedList<Node>();
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					temp.add(node.left);
				}
				if (node.right != null) {
					temp.add(node.right);
				}
			}
			queue = temp;
			list.add(level);
		}

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 != 0) {
				Collections.reverse(list.get(i));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		BinaryTreeZigZagOrderTraversal_103 tree = new BinaryTreeZigZagOrderTraversal_103();
		tree.root = new Node(3);
		tree.root.left = new Node(9);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(7);
		tree.printZigZag();
	}

}

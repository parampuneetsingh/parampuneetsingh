//https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPairs_24 {

	Node head;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public int Data() {
			return data;
		}
	}

	public SwapNodesInPairs_24() {
		head = null;
	}

	public void insertHead(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.Data());
			current = current.next;
		}
	}

	public void swapPairs() {
		swapPairs(head);
	}

	public Node swapPairs(Node head) {
		Node node = new Node(-1);
		node.next = head;
		Node curr = node;

		while (curr.next != null && curr.next.next != null) {
			Node first = curr.next;
			Node second = curr.next.next;
			first.next = second.next;
			second.next = first;
			curr.next = second;
			curr = curr.next.next;
		}
		return node.next;
	}

	public static void main(String[] args) {
		SwapNodesInPairs_24 createLinkedLst = new SwapNodesInPairs_24();

		createLinkedLst.insertHead(5);
		createLinkedLst.insertHead(4);
		createLinkedLst.insertHead(3);
		createLinkedLst.insertHead(2);
		createLinkedLst.insertHead(1);
		createLinkedLst.swapPairs(); // https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11194/Java-recursive-and-iterative-solutions-both-cost-0ms
	}

}

public class RemoveNthNode_19 {

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

	public RemoveNthNode_19() {
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
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public Node removeNthFromEnd(int n) {
		Node resp = new Node(0);
		resp.next = head;
		Node first = resp;
		Node second = resp;
		
		for (int i = 0; i <= n ; i++) {
			first = first.next;
		}
		
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;

		return resp.next;
	}

	public Node deleteValueNode(int n) {
		if (head.data == n) {
			head = head.next;
			return head;
		}

		Node current = head;

		while (current.next != null) {
			if (current.next.data == n) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}

		return head;
	}

	public static void main(String[] args) {
		RemoveNthNode_19 nnode = new RemoveNthNode_19();
		nnode.insertHead(5);
		nnode.insertHead(4);
		nnode.insertHead(3);
		nnode.insertHead(2);
		nnode.insertHead(1);
		// 1 -> 2 -> 3 -> 4 -> 5 -> 0
		// Output 1 -> 2 -> 3 -> 5
		nnode.removeNthFromEnd(2);
		//nnode.deleteValueNode(1);
		nnode.print();
	}

}

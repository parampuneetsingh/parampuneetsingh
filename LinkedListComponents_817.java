import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents_817 {

	ListNode head;

	class ListNode {
		ListNode next;
		int val;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public int lisComponents(int[] G) {
		return numComponents(head, G);
	}

	public int numComponents(ListNode head, int[] G) {
		Set<Integer> sets = new HashSet<Integer>();
		ListNode current = head;
		int res = 0;

		for (int i : G) {
			sets.add(i);
		}

		while (current != null) {
			if (sets.contains(current.val) && (current.next == null || !sets.contains(current.next.val))) {
				res++;
			}
			current = current.next;
		}

		return res;
	}

	public static void main(String[] args) {
		LinkedListComponents_817 list = new LinkedListComponents_817();
		int[] G = { 0, 1, 3 };
		list.insertHead(3);
		list.insertHead(2);
		list.insertHead(1);
		list.insertHead(0);
		System.out.println(list.lisComponents(G));
	}

}

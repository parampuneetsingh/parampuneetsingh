import java.util.HashMap;

public class LRUCache_146 {

	private HashMap<Integer, ListNode> map;
	private ListNode head;
	private ListNode tail;
	private int size;

	public class ListNode {
		int key;
		int val;
		ListNode next;
		ListNode prev;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public LRUCache_146(int size) {
		map = new HashMap<Integer, ListNode>();
		this.size = size;
		this.head = null;
		this.tail = null;
	}

	public int search(int key) {
		int resp = -1;
		if (map.containsKey(key)) {
			ListNode result = map.get(key);
			remove(result);
			setHead(result);
			resp = result.val;
		}
		return resp;
	}

	public void remove(ListNode n) {
		if (n.prev != null) {
			n.prev.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.prev = n.prev;
		} else {
			tail = n.prev;
		}

	}

	public void setHead(ListNode n) {
		n.next = head;
		n.prev = null;

		if (head != null)
			head.prev = n;

		head = n;

		if (tail == null)
			tail = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			ListNode old = map.get(key);
			old.val = value;
			remove(old);
			setHead(old);
		} else {
			ListNode created = new ListNode(key, value);
			if (map.size() >= size) {
				map.remove(tail.key);
				remove(tail);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}

	public void printCache( ) {
		ListNode temp = head;
		System.out.print("Elements in Cache " + " ");
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
	} 
	
	public static void main(String[] args) {
		LRUCache_146 lru=new LRUCache_146(5);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		lru.set(4, 4);
		lru.set(5, 5);
		lru.printCache();
		int val=lru.search(3);
		System.out.println(""+val);
		lru.printCache();
		lru.set(6, 6);
		int val2=lru.search(2);
		System.out.println(""+val2);
		lru.printCache();
	}

}

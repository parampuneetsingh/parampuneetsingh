//https://leetcode.com/problems/design-circular-queue

public class DesignCircularQueue_LinkedListSoln_622 {

	ListNode head;
	ListNode tail;
	int k;
	int idx = 0;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public DesignCircularQueue_LinkedListSoln_622(int k) {
		this.k = k;
		head = null;
		tail = null;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (!isFull()) {
			ListNode node = new ListNode(value);
			if (head == null) {
				head = node;
				tail = node;
				tail.next = head;
			} else {
				tail.next = node;
				tail = node;
				node.next = head;
			}
			idx++;
			return true;
		}
		return false;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
			tail.next = head;
		}
		idx--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return isEmpty() ? -1 : head.val;
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return isEmpty() ? -1 : tail.val;
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return (idx == 0);
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (idx == k);
	}
	
	public static void main(String[] args) {
		/*DesignCircularQueue_LinkedListSoln_622 circularQueue = new DesignCircularQueue_LinkedListSoln_622(3); // set the size to be 3
		circularQueue.enQueue(1); // return true
		circularQueue.enQueue(2); // return true
		circularQueue.enQueue(3); // return true
		circularQueue.enQueue(4); // return false, the queue is full
		circularQueue.Rear(); // return 3
		circularQueue.isFull(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.enQueue(4); // return true
		circularQueue.Rear(); // return 4
		*/
		DesignCircularQueue_LinkedListSoln_622 circularQueue = new DesignCircularQueue_LinkedListSoln_622(7);
		circularQueue.enQueue(0);
		circularQueue.Front();
		circularQueue.enQueue(4);
		circularQueue.Rear();
		circularQueue.enQueue(6);
		circularQueue.enQueue(3);
		circularQueue.Rear();
		circularQueue.deQueue();
		circularQueue.Front();
		circularQueue.deQueue();
		circularQueue.Front();
	}

}

//https://leetcode.com/problems/design-circular-queue/

public class DesignCircularQueue_622 {

	int[] aryChar;
	int k;
	int front, rear = -1, idx = 0;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public DesignCircularQueue_622(int k) {
		this.k = k;
		aryChar = new int[k];
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (!isFull()) {
			rear = (rear+1) % k;
			aryChar[rear] = value;
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
		front = (front+1) % k;
		idx--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return isEmpty() ? -1 : aryChar[front];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return isEmpty() ? -1 : aryChar[rear];
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
		/*DesignCircularQueue_622 circularQueue = new DesignCircularQueue_622(3); // set the size to be 3
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
		DesignCircularQueue_622 circularQueue = new DesignCircularQueue_622(7); // set the size to be 3
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

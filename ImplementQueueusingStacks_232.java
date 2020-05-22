import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

public class ImplementQueueusingStacks_232 {

	Stack<Integer> queue;
	Stack<Integer> buffer;

	/** Initialize your data structure here. */
	public ImplementQueueusingStacks_232() {
		queue = new Stack<Integer>();
		buffer = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (queue.isEmpty()) {
			queue.push(x);
		} else {
			while (!queue.isEmpty()) {
				buffer.push(queue.pop());
			}
			queue.push(x);
			while (!buffer.isEmpty()) {
				queue.push(buffer.pop());
			}
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (!queue.isEmpty()) {
			return queue.pop();
		}
		return -1;
	}

	/** Get the front element. */
	public int peek() {
		if (!queue.isEmpty()) {
			return queue.peek();
		}
		return -1;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		ImplementQueueusingStacks_232 queue = new ImplementQueueusingStacks_232();

		queue.push(1);
		queue.push(2);
		queue.peek(); // returns 1
		queue.pop(); // returns 1
		queue.empty(); // returns false
	}

}

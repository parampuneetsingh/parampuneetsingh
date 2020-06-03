//https://leetcode.com/problems/min-stack/
//https://www.youtube.com/watch?v=8Ub73n4ySYk

public class MinStack_155 {

	TopStack stack;

	class TopStack {
		int min;
		int value;
		TopStack next;

		public TopStack(int value) {
			this.min = value;
			this.value = value;
			next = null;
		}
	}

	/** initialize your data structure here. */
	public MinStack_155() {
		stack = null;
	}

	public void push(int x) {
		if (stack == null) {
			stack = new TopStack(x);
		} else {
			TopStack temp = new TopStack(x);
			temp.next = stack;
			temp.min = Math.min(x, stack.min);
			stack = temp;
		}
	}

	public void pop() {
		if (stack != null) {
			stack = stack.next;
		}
	}

	public int top() {
		if (stack == null) {
			return -1;
		}
		return stack.value;
	}

	public int getMin() {
		if (stack == null) {
			return -1;
		}
		return stack.min;
	}

	public static void main(String[] args) {
		MinStack_155 minStack = new MinStack_155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // Returns -3
		minStack.pop();
		minStack.top(); // Returns 0.
		minStack.getMin();
	}

}

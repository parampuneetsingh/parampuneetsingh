import java.util.Stack;

//https://www.lintcode.com/problem/max-stack/
//https://leetcode.com/articles/max-stack/

public class MaxStack_716 {

	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack_716() {
		stack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public void push(int x) {
		int max = maxStack.isEmpty() ? x : maxStack.peek();
		maxStack.push(max > x ? max : x);
		stack.push(x);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = peekMax();
		Stack<Integer> buffer = new Stack<Integer>();
		while (top() != max)
			buffer.push(pop());
		pop();
		while (!buffer.isEmpty())
			push(buffer.pop());
		return max;
	}

	public static void main(String[] args) {
		MaxStack_716 stack = new MaxStack_716();
		stack.push(5);
		stack.push(1);
		stack.push(5);
		stack.top(); // -> 5
		stack.popMax();// -> 5
		stack.top();// -> 1
		stack.peekMax();// -> 5
		stack.pop(); // -> 1
		stack.top(); // -> 5
	}

}

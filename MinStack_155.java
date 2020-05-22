import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/min-stack/

public class MinStack_155 {

	int size = 0;
	List<Integer> min;
	List<Integer> stackList;

	/** initialize your data structure here. */
	public MinStack_155() {
		stackList = new ArrayList<Integer>();
		size = 0;
		min = new ArrayList<Integer>();
	}

	public void push(int x) {
		if (min.isEmpty()) {
			min.add(x);
		} else {
			if (x < min.get(size - 1)) {
				min.add(x);
			} else {
				min.add(min.get(size - 1));
			}
		}
		stackList.add(x);
		size++;
	}

	public void pop() {
		if (size > 0) {
			stackList.remove(size - 1);
			min.remove(size - 1);
			size--;
		}
	}

	public int top() {
		return stackList.get(size - 1);
	}

	public int getMin() {
		return min.get(size - 1);
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

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/

//Constant Time and Space Complexity
public class MinStack_2_155 {

    Stack<Integer> stk;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack_2_155() {
         stk = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (stk.isEmpty()) {
            stk.push(x);
            min = x;
        } else if (x < min){
            stk.push(2*x - min);
            min = x;
        } else {
            stk.push(x);
        }
    }
    
    public void pop() {
        int temp = stk.pop();
        if (temp < min) {
            min = 2*min - temp;
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }

	public static void main(String[] args) {
		MinStack_2_155 minStack = new MinStack_2_155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // Returns -3
		minStack.pop();
		minStack.top(); // Returns 0.
		minStack.getMin();
	}

}

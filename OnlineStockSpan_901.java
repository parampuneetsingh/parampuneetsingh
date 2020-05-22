import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/

public class OnlineStockSpan_901 {

	Stack<Integer> weight;
	Stack<Integer> prices;

	public OnlineStockSpan_901() {
		weight = new Stack<Integer>();
		prices = new Stack<Integer>();
	}

	public int next(int price) {
		int res = 1;

		while (!prices.isEmpty() && prices.peek() <= price) {
			prices.pop();
			res += weight.pop();
		}

		prices.push(price);
		weight.push(res);

		return res;
	}

	public static void main(String[] args) {
		OnlineStockSpan_901 S = new OnlineStockSpan_901();
		// S.next(100); // is called and returns 1,
		// S.next(80); // is called and returns 1,
		// S.next(60); // is called and returns 1,
		// S.next(70); // is called and returns 2,
		// S.next(60); // is called and returns 1,
		// S.next(75); // is called and returns 4,
		// S.next(85); // is called and returns 6.

		S.next(29); // is called and returns 1,
		S.next(91); // is called and returns 2,
		S.next(62); // is called and returns 1,
		S.next(76); // is called and returns 2,
		S.next(51); // is called and returns 1,
	}

}

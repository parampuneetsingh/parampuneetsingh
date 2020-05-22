import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveAllAdjacentDuplicateInString_1209 {

	class Element {
		char c;
		int freq;

		public Element(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

	public String removeDuplicates(String s, int k) {
		Stack<Element> stk = new Stack<Element>();

		for (char ch : s.toCharArray()) {
			if (!stk.isEmpty() && stk.peek().c == ch) {
				stk.peek().freq++;
			} else {
				stk.push(new Element(ch, 1));
			}

			if (stk.peek().freq == k) {
				stk.pop();
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!stk.isEmpty()) {
			Element e = stk.pop();

			for (int i = 0; i < e.freq; i++) {
				sb.insert(0, e.c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicateInString_1209 rem = new RemoveAllAdjacentDuplicateInString_1209();
		String s = "deeedbbcccbdaa";
		int k = 3;
		rem.removeDuplicates(s, k);
	}

}

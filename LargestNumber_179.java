import java.util.PriorityQueue;

//https://leetcode.com/problems/largest-number/

public class LargestNumber_179 {

	public static String largestNumber(int[] nums) {
		if (nums.length == 0)
			return "";

		PriorityQueue<String> pQ = new PriorityQueue<String>(
				(a, b) -> Long.valueOf(b + a).compareTo(Long.valueOf(a + b)));
		for (int num : nums) {
			pQ.add(String.valueOf(num));
		}

		StringBuilder sb = new StringBuilder();

		while (!pQ.isEmpty()) {
			sb.append(pQ.remove());
		}

		return sb.toString().startsWith("0") ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(nums));
	}

}

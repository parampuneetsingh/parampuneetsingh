import java.util.HashMap;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
//https://www.youtube.com/watch?v=uJ8BAQ8lASE

public class SplitArrayIntoConsecutiveSubsequences_659 {

	public static boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();

		for (int i : nums) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}

		for (int n : nums) {
			if (freqMap.get(n) == 0) {
				continue;
			}
			if (buffer.getOrDefault(n, 0) > 0) {
				buffer.put(n, buffer.get(n) - 1);
				freqMap.put(n, freqMap.get(n) - 1);
				buffer.put(n + 1, buffer.getOrDefault(n + 1, 0) + 1);
			} else if (freqMap.getOrDefault(n, 0) > 0 && freqMap.getOrDefault(n + 1, 0) > 0
					&& freqMap.getOrDefault(n + 2, 0) > 0) {
				freqMap.put(n, freqMap.get(n) - 1);
				freqMap.put(n + 1, freqMap.get(n + 1) - 1);
				freqMap.put(n + 2, freqMap.get(n + 2) - 1);
				buffer.put(n + 3, buffer.getOrDefault(n + 3, 0) + 1);
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 5 };
		System.out.println(isPossible(nums));
	}

}

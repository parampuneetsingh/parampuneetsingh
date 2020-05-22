import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/
//https://www.youtube.com/watch?v=YkacnIOt2jM

public class SubarraySumEqualsK_560 {

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] subAry = new int[nums.length];
		int count = 0;
		int curr_sum = 0;
		subAry[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			subAry[i] = nums[i] + subAry[i - 1];
		}

		for (int j = 0; j < nums.length; j++) {
			curr_sum += nums[j];
			if (curr_sum == k) {
				count++;
			}

			if (map.containsKey(curr_sum - k)) {
				count += map.get(curr_sum - k);
			}

			map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		SubarraySumEqualsK_560 subArray = new SubarraySumEqualsK_560();
		int[] nums = { 1, 0, 1, 2, -1 };
		System.out.println(subArray.subarraySum(nums, 2));
	}

}

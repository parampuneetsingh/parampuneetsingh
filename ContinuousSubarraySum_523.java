import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/continuous-subarray-sum/
//http://buttercola.blogspot.com/2018/10/leetcode-523-continuous-subarray-sum.html

public class ContinuousSubarraySum_523 {

	public static boolean checkSubarraySum2(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		int[] preSum = new int[nums.length];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = nums[i] + preSum[i - 1];
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		for (int i = 0; i < preSum.length; i++) {

			int res = preSum[i];
			if (k != 0) {
				res = preSum[i] % k;
			}
			if (map.containsKey(res) && (i - map.get(res)) > 1) {
				return true;
			}

			if (!map.containsKey(res)) {
				map.put(res, i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 23, 2, 4, 6, 7 };
		int k = 6;
		System.out.println(checkSubarraySum2(nums, k));
	}

}

import java.util.Arrays;
import java.util.HashMap;

/*Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.*/

public class TwoSumInArray {

	public int[] twoSumHash(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int remainder = target - nums[i];
			if (map.containsKey(remainder)) {
				return new int[] { map.get(remainder), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}

	public int[] twoSum(int[] nums, int target) {

		int index;
		int[] resp = new int[2];
		Integer[] tempArray = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (Arrays.asList(tempArray).contains(nums[i])) {
				index = Arrays.asList(tempArray).indexOf(nums[i]);
				resp[0] = index;
				resp[1] = i;
				return resp;
			} else {
				tempArray[i] = target - nums[i];
			}
		}
		return null;
	}

	public int[] twoSumRevision(int[] nums, int target) {
		int[] resp = new int[2];
		Integer[] numAry = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if (Arrays.asList(numAry).contains(j)) {
				resp[0] = Arrays.asList(numAry).indexOf(j);
				resp[1] = i;
				return resp;
			} else {
				numAry[i] = target - j;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int ary[] = { 2, 4, 7, 0 };
		int target = 9;
		TwoSumInArray numAry = new TwoSumInArray();
		numAry.twoSumHash(ary, target); // Solution 1 using HashMap
		// numAry.twoSum(ary, target); //Solution 2 using HashMap
	}

}

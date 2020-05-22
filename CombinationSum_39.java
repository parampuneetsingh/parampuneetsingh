import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum_39 {

	public static void backTrack(List<List<Integer>> lst, List<Integer> subList, int[] nums, int sum, int idx) {
		if (sum == 0) {
			lst.add(new ArrayList<Integer>(subList));
			return;
		}

		for (int i = idx; i < nums.length && nums[i] <= sum; i++) {
			subList.add(nums[i]);
			backTrack(lst, subList, nums, sum - nums[i], i);
			subList.remove(subList.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		backTrack(lst, new ArrayList<Integer>(), candidates, target, 0);
		return lst;
	}

	public static void main(String[] args) {
		int[] combinationSum = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum(combinationSum, target));
	}

}

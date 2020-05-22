import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/4sum/

public class FourSum_18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1, l = nums.length - 1;
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum < target)
						k++;
					else if (sum > target)
						l--;
					else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list.add(nums[l]);
						ans.add(list);
						if (nums[k] == nums[l])
							break;
						while (k + 1 < l && nums[k] == nums[k + 1])
							k++;
						while (l - 1 > k && nums[l] == nums[l - 1])
							l--;
						k++;
						l--;
					}
				}
			}
		}
		return ans;
	}

	public List<List<Integer>> fourSum2(int[] nums, int target) {
		HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		List<List<Integer>> resp = new ArrayList<List<Integer>>();

		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = nums[i] + nums[j];

				if (map.containsKey(target - sum)) {
					List<int[]> indexes = map.get(target - sum);
					for (int[] index : indexes) {
						// Here we already know that we can get 4 nums to get the target value, but we
						// need those four nums comes in order
						// assume we have first two nums nums[k], nums[l], and current nums are nums[i],
						// nums[j], by definition, k < l and i < j are certain. So we only need to make
						// sure that l < i, then we can get k < l < i < j, and add it to result set
						if (index[1] < i) {
							// make a result
							List<Integer> candidate = Arrays.asList(nums[index[0]], nums[index[1]], nums[i], nums[j]);
							Collections.sort(candidate);
							if (!resp.contains(candidate)) {
								resp.add(candidate);
							}
						}
					}
				}

				List<int[]> list = map.getOrDefault(sum, new ArrayList<int[]>());
				list.add(new int[] { i, j });
				map.put(sum, list);
			}
		}
		return resp;
	}

	public static void main(String[] args) {
		FourSum_18 findSum = new FourSum_18();
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		System.out.println(findSum.fourSum(nums, target));
	}

}

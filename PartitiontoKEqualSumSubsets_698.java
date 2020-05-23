import java.util.Arrays;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

public class PartitiontoKEqualSumSubsets_698 {

	public boolean recurse(int[] nums, int k, int sum, int part, boolean[] visited, int currSum, int idx) {
		if (k == 0) {
			return true;
		}

		if (currSum > part) {
			return false;
		}

		if (currSum == part) {
			return recurse(nums, k - 1, sum, part, visited, 0, 0);
		}

		for (int i = idx; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (recurse(nums, k, sum, part, visited, currSum + nums[i], i + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}

		return false;
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		boolean[] visited = new boolean[nums.length];

		for (int i : nums) {
			sum += i;
		}

		Arrays.sort(nums);

		return recurse(nums, k, sum, sum / k, visited, 0, 0);
	}

	public static void main(String[] args) {
		PartitiontoKEqualSumSubsets_698 partition = new PartitiontoKEqualSumSubsets_698();
		int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
		int k = 4;
		System.out.println(partition.canPartitionKSubsets(nums, k));
	}

}

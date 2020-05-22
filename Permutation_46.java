import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation_46 {

	public void backTrack(List<List<Integer>> resp, List<Integer> list, HashSet<Integer> visited, int[] nums) {
		if (list.size() == nums.length) {
			resp.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited.contains(nums[i])) {
				list.add(nums[i]);
				visited.add(nums[i]);
				backTrack(resp, list, visited, nums);
				list.remove(list.size() - 1);
				visited.remove(nums[i]);
			}
		}

	}

	// Solution 2
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> resp = new ArrayList<List<Integer>>();

		backTrack(resp, new ArrayList<>(), new HashSet<>(), nums);

		return resp;
	}

	// Recursive Solution
	private void collectPermutations(int[] nums, int start, List<Integer> permutation,
			List<List<Integer>> permutations) {

		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			return;
		}

		for (int i = 0; i <= permutation.size(); i++) {
			List<Integer> newPermutation = new ArrayList<Integer>(permutation);
			newPermutation.add(i, nums[start]);
			collectPermutations(nums, start + 1, newPermutation, permutations);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return permutations;
		}

		collectPermutations(nums, 0, new ArrayList<Integer>(), permutations);
		return permutations;
	}

	public static void main(String[] args) {
		int[] ary = { 1, 2, 3 };
		Permutation_46 perm = new Permutation_46();
		List<List<Integer>> permResp = perm.permute2(ary);
		System.out.println(permResp);

	}

}

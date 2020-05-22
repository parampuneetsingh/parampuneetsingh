import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
//https://www.youtube.com/watch?v=IER1ducXujU

public class CombinationSumII_40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		List<Integer> combination = new ArrayList<Integer>();
		findCombination(candidates, 0, target, combination, result);

		return result;
	}

	public void findCombination(int[] candidates, int index, int target,
			List<Integer> current, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		if (target < 0) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				findCombination(candidates, i + 1, target - candidates[i], current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII_40 combination = new CombinationSumII_40();
		/*int candidates[] = {10,1,2,7,6,1,5};
		int target = 8;*/
		int candidates[] = {1, 3, 2, 1};
		int target = 3;
		combination.combinationSum2(candidates, target);
	}

}

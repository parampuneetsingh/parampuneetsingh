import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public void backTrack(List<List<Integer>> list, List<Integer> subList, int n, int k, int pos) {
		if (subList.size() == k) {
			list.add(new ArrayList<Integer>(subList));
			return;
		}

		for (int i = pos; i <= n; i++) {
			subList.add(i);
			backTrack(list, subList, n, k, i + 1);
			subList.remove(subList.size() - 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> subList = new ArrayList<List<Integer>>();
		backTrack(subList, new ArrayList<Integer>(), n, k, 1);
		return subList;
	}

	public static void main(String[] args) {
		Combinations_77 findCombinations = new Combinations_77();
		findCombinations.combine(4, 2);
	}

}

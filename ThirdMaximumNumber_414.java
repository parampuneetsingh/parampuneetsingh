import java.util.TreeSet;

public class ThirdMaximumNumber_414 {

	public static int thirdMax(int[] nums) {
		TreeSet<Integer> sets = new TreeSet<Integer>();
		int counter = 0;
		for (int i : nums) {
			sets.add(i);
		}

		if (sets.size() < 3) {
			return sets.pollLast();
		}

		while (counter < 2) {
			sets.pollLast();
			counter++;
		}

		return sets.pollLast();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1 };
		thirdMax(nums);
	}

}

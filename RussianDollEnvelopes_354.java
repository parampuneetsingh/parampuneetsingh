import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/russian-doll-envelopes/
//https://www.programcreek.com/2016/08/leetcode-russian-doll-envelopes-java/
//https://www.youtube.com/watch?v=aytjGaGwQhc

public class RussianDollEnvelopes_354 {

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		ArrayList<Integer> list = new ArrayList<>();

		for (int[] arr : envelopes) {
			int target = arr[1];

			if (list.isEmpty() || target > list.get(list.size() - 1)) {
				list.add(target);
			} else {
				int i = 0;
				int j = list.size() - 1;

				while (i < j) {
					int m = i + (j - i) / 2;
					if (list.get(m) >= target) {
						j = m;
					} else {
						i = m + 1;
					}
				}

				list.set(j, target);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		RussianDollEnvelopes_354 max = new RussianDollEnvelopes_354();
		// int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int[][] envelopes = { { 2, 100 }, { 3, 200 }, { 4, 300 }, { 5, 500 }, { 5, 400 }, { 5, 250 }, { 6, 370 },
				{ 6, 360 }, { 7, 380 } };
		System.out.println(max.maxEnvelopes(envelopes));
	}

}

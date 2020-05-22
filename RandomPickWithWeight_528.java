import java.util.TreeMap;

//https://leetcode.com/problems/random-pick-with-weight/
//https://www.youtube.com/watch?v=KAZM4tsH8aI

public class RandomPickWithWeight_528 {

	private TreeMap<Integer, Integer> map;
	private int sum;

	public RandomPickWithWeight_528(int[] w) {
		map = new TreeMap<Integer, Integer>();
		sum = 0;
		for (int i = 0; i < w.length; i++) {
			map.put(sum, i);
			sum += w[i];
		}
	}

	public int pickIndex() {
		int floor = (int) (Math.random() * sum);
		return map.floorEntry(floor).getValue();
	}

	public static void main(String[] args) {
		int[] w = { 4, 2 };
		RandomPickWithWeight_528 weight = new RandomPickWithWeight_528(w);
		weight.pickIndex();
	}

}

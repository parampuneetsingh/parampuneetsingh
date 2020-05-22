import java.util.TreeMap;

public class HandOfStraights_846 {

	public static boolean isNStraightHand(int[] hand, int W) {
		if ((hand.length % W) != 0) {
			return false;
		}

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i : hand) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		while (map.size() != 0) {
			int t = map.firstKey();

			for (int k=t; k < t + W; k++) {
				if (!map.containsKey(k)) {
					return false;
				}
				map.put(k, map.get(k) - 1);
				if (map.get(k) == 0) {
					map.remove(k);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] hand = { 1,2,3,6,2,3,4,7,8 };
		int W = 3;
		System.out.println(isNStraightHand(hand, W));
	}

}

import java.util.HashMap;

//https://leetcode.com/problems/bulls-and-cows/
//https://www.programcreek.com/2014/05/leetcode-bulls-and-cows-java/

public class BullsAndCows_299 {

	// Solution 2 -> Better and Easy
	public static String getHint2(String secret, String guess) {
		int countBull = 0;
		int countCow = 0;
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];

		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);

			if (c1 == c2)
				countBull++;
			else {
				arr1[c1 - '0']++;
				arr2[c2 - '0']++;
			}
		}

		for (int i = 0; i < 10; i++) {
			countCow += Math.min(arr1[i], arr2[i]);
		}

		return countBull + "A" + countCow + "B";
	}
	
	// Soluton 1
	public static String getHint(String secret, String guess) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int A = 0, B = 0;

		for (int i = 0; i < guess.length(); i++) {
			int a = guess.charAt(i) - '0';
			int b = secret.charAt(i) - '0';
			if (a == b) {
				A++;
			} else {
				map.put(a, map.getOrDefault(a, 0) + 1);
			}
		}

		for (int j = 0; j < secret.length(); j++) {
			int a = guess.charAt(j) - '0';
			int b = secret.charAt(j) - '0';
			if (a != b && map.containsKey(b)) {
				B++;
				map.put(b, map.get(b) - 1);
				if (map.get(b) == 0) {
					map.remove(b);
				}
			}
		}

		return A + "A" + B + "B";
	}

	public static void main(String[] args) {
		String secret = "1123", guess = "0111";
		System.out.println(getHint2(secret, guess));
	}

}

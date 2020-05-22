import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i == (s.length() - 1)) {
				count = count + map.get(s.charAt(i));
			} else if (map.get(s.charAt(i)) == map.get(s.charAt(i + 1))) {
				if (map.get(s.charAt(i)) % 10 == 5) {
					System.out.println("Invalid Number");
					break;
				} else {
					count = count + map.get(s.charAt(i));
				}
			} else if (map.get(s.charAt(i)) > map.get(s.charAt(i + 1))) {
				count = count + map.get(s.charAt(i));
			} else {
				count = count + (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
				i++;
			}
		}
		return count;
	}

	// Easy Solution
	public int romanToInt2(String s) {
		String[] keys = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		int val = 0;
		int idx = 0;
		int n = s.length();
		while (idx < n) {
			char c = s.charAt(idx);
			if (idx + 1 < n && map.containsKey(s.substring(idx, idx + 2))) {
				val += map.get(s.substring(idx, idx + 2));
				idx += 2;
			} else {
				val += map.get(String.valueOf(c));
				idx++;
			}
		}
		return val;
	}

	public static void main(String[] args) {
		String str = "MCMXCVI";

		RomanToInteger_13 R2I = new RomanToInteger_13();
		R2I.romanToInt(str);
	}

}

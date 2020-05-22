import java.util.HashMap;

public class StrobogrammaticNumber_246 {

	public static boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		StringBuilder sb = new StringBuilder();

		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		for (int i = 0; i < num.length(); i++) {
			sb.append(map.get(num.charAt(i)));
		}

		return num.equals(sb.reverse().toString());
	}

	public static void main(String[] args) {
		isStrobogrammatic("69");
	}
}
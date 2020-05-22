//https://leetcode.com/problems/count-and-say/

public class CountAndSay_38 {

	//Faster Solution
	public String countAndSay2(int n) {
		StringBuilder sb;
		String result = "1";
		int count = 1;
		int say;

		while (count < n) {
			sb = new StringBuilder();
			say = 1;
			for (int i = 0; i < result.length() - 1; i++) {
				if (result.charAt(i) == result.charAt(i + 1)) {
					say++;
				} else {
					sb.append(say + "" + result.charAt(i));
					say = 1;
				}
			}

			sb.append(say + "" + result.charAt(result.length() - 1));

			result = sb.toString();
			count++;
		}
		return result;
	}

	public String countAndSay(int n) {
		String result = "1";
		for (int outer = 1; outer < n; outer++) {
			String previous = result;
			result = "";
			int count = 1;
			char say = previous.charAt(0);

			for (int i = 1; i < previous.length(); i++) {
				if (previous.charAt(i) != say) {
					result = result + count + say;
					count = 1;
					say = previous.charAt(i);
				} else
					count++;
			}
			result = result + count + say;
		}
		return result;
	}

	public static void main(String[] args) {
		CountAndSay_38 cas = new CountAndSay_38();
		System.out.println(cas.countAndSay(5));
	}

}

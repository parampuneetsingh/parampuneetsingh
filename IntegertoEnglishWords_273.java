//https://leetcode.com/problems/integer-to-english-words/
//https://www.youtube.com/watch?v=qwotMTggot0

public class IntegertoEnglishWords_273 {

	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };;
	private final String[] TENS = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	private final String[] TWENTIES = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	public void helper(StringBuilder sb, int num) {
		if (num == 0) {
			return;
		} else if (num < 20) {
			sb.append(TWENTIES[num]).append(" ");
			return;
		} else if (num < 100) {
			sb.append(TENS[num / 10]).append(" ");
			helper(sb, num % 10);
		} else {
			sb.append(TWENTIES[num / 100]).append(" Hundred ");
			helper(sb, num % 100);
		}

	}

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		StringBuilder sb = new StringBuilder();
		int index = 0;

		while (num > 0) {
			if (num % 1000 != 0) {
				StringBuilder temp = new StringBuilder();
				helper(temp, num % 1000);
				sb.insert(0, temp.append(THOUSANDS[index]).append(" "));
			}

			index++;
			num = num / 1000;
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		IntegertoEnglishWords_273 englishWords = new IntegertoEnglishWords_273();
		System.out.println(englishWords.numberToWords(1234567));
	}

}

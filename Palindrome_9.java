
public class Palindrome_9 {

	public boolean isPalindrome(int x) {
		int temp = x;
		int resp = 0;
		while (temp > 0) {
			resp = (resp * 10) + (temp % 10);
			temp = temp / 10;
		}

		if (resp == x) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPalindrome2(int x) {
		int revertedNum = 0;
		while (x > revertedNum) {
			revertedNum = (revertedNum * 10) + (x % 10);
			x = x / 10;
		}

		return x == revertedNum || x == revertedNum/10;
	}

	public static void main(String[] args) {
		int x = 112232211;
		Palindrome_9 pld = new Palindrome_9();
		pld.isPalindrome(x);
		pld.isPalindrome2(x);// Solution 2
	}

}

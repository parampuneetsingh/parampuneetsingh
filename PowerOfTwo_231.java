//https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
public class PowerOfTwo_231 {

	// Solution 2
	public boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		while (n % 2 == 0) {
			n >>= 1;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		int x = 4;
		// Solution 1
		System.out.println(x != 0 && ((x & (x - 1)) == 0));
	}

}

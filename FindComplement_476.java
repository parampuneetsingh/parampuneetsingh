//Input: 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

//https://leetcode.com/problems/number-complement/
//https://www.youtube.com/watch?v=bG3Dg6Q5RRw
//https://www.youtube.com/watch?v=oURSuMY4zSc

public class FindComplement_476 {

	// Solution 1
	public int findComplement(int num) {
		//Or Find x this way
		//int x = (int) (Math.log(num) / Math.log(2)) + 1;
		
		int x = 0;
		int n = num;
		
		while (n > 0) {
			x++;
			n = n >> 1;
		}
		
		//Or use this one
		//int mask = Math.pow(2, x) - 1;
		int mask = (1 << x) - 1;

		return num ^ mask;
	}

	// Solution 2
	public int findComplement2(int num) {
		int result = 0;		int power = 1;
		while (num > 0) {
			result += (num % 2 ^ 1) * power;
			power <<= 1;
			num >>= 1;
		}

		return result;
	}

	public static void main(String[] args) {
		FindComplement_476 find = new FindComplement_476();
		System.out.println(find.findComplement(5));
	}

}

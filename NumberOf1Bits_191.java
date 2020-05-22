//https://leetcode.com/problems/number-of-1-bits/

public class NumberOf1Bits_191 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 11; //Consider it unsigned integer

		/* This scenario will also work but it'll fail for Integer.MAX_VALUE;	
		 * while (n > 0) { 
		 * count = ((n & 1) == 1) ? count+1 : count; 
		 * n=n>>1; 
		 * }
		 */
		int count = 0;
		 
        while (n != 0) {
            count++;
            n &=(n-1);
        }
        
		System.out.println(count);
	}

}

//https://leetcode.com/problems/bitwise-and-of-numbers-range/
//https://www.youtube.com/watch?v=ho9cihIwQDY

public class BitwiseANDofNumbersRange_201 {

    public static int rangeBitwiseAnd(int m, int n) {
        
        int count = 0;

        while (m < n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
           
        return m<<count;
    }
    
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}
}

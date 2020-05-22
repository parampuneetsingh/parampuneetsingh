//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//https://www.youtube.com/watch?v=4LoajzOxF4I

public class FindNUniqueIntegersSumuptoZero_1304 {

	 public static int[] sumZero(int n) {
	        int flag = n%2;
	        int[] res = new int[n];
	        
	        int counter = 0;
	        for (int i=1;i<=n/2;i++) {
	            res[counter++] = i;
	            res[counter++] = -i;
	        }
	        
	        if (flag == 1) {
	            res[counter++] = 0;
	        }
	        
	        return res;
	    }
	 
	public static void main(String[] args) {
		System.out.println(sumZero(5));
	}
}

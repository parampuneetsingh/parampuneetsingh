import java.util.Arrays;

public class HeightChecker_1051 {

	 public static int heightChecker(int[] heights) {
	        int[] tempArray = new int[heights.length];
	        int res = 0;
	        
	        for (int i=0; i< heights.length; i++) {
	            tempArray[i] = heights[i];
	        }
	        
	        Arrays.sort(tempArray);
	        
	        for (int j=0; j< heights.length; j++) {
	            if (tempArray[j] != heights[j]) {
	                res++;
	            }
	        }
	        
	        return res;
	    }
	 
	public static void main(String[] args) {
		int[] nums = {1,1,4,2,1,3};
		
		heightChecker(nums);

	}

}

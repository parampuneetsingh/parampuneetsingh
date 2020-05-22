
public class FindPivotIndex_724 {

	//Solution 1
	public static int pivotIndex(int[] nums) {
	       int sum = 0;
	        for(int i:nums){
	            sum +=i;
	        }
	        
	        int tempSum = 0;
	        
	        for(int j=0;j<nums.length;j++) {
	            if (sum-nums[j] == tempSum * 2) {
	                return j;
	            }
	            tempSum +=nums[j];
	        }
	        return -1;
	    }
	
	//Solution2
    public int pivotIndex2(int[] nums) {
      int total = 0;
      int tempSum = 0;
        
        for (int i=0;i<nums.length; i++) {
            total +=nums[i];
        }
        
        for (int k=0;k<nums.length; k++) {
            if (tempSum == total - tempSum - nums[k]) {
                return k;
            }
            tempSum +=nums[k];
        }
        return -1;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		pivotIndex(nums);
	}

}

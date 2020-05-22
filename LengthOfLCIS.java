
public class LengthOfLCIS {

	public int findLengthOfLCIS(int[] nums) {
    	int len = 0;
    	int max = 0;
    	for(int i = 0;i < nums.length;i++){
    		if(i == 0 || nums[i] > nums[i-1]){
    			len++;
    		}else{
    			len = 1;
    		}
    		max = Math.max(max, len);
        }
    	return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {5, 3, 8, 9, 10, 2, 1};
		LengthOfLCIS lcis = new LengthOfLCIS();
		System.out.println(lcis.findLengthOfLCIS(nums));
	}

}

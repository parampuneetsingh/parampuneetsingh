
public class MaxSubarray {

	public int maxSubArray(int[] nums) {
		int resp = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int tempI = nums[i];
			while (j < nums.length) {
				int temp = tempI + nums[j];
				if (temp >= resp) {
					resp = temp;
					tempI = temp;
					j++;
				}
			}
		}
		return resp;
	}

	public int maxSubArray2(int[] nums) {
		int maxsum = nums[0];
		int maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);
			maxsum = Math.max(maxEndingHere, maxsum);
		}
		return maxsum;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,-4,1,3,-2,3,-1};
		//{ -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaxSubarray subAry = new MaxSubarray();
		//int response = subAry.maxSubArray(nums);//TiimeLimit Exceeded
		int response2 = subAry.maxSubArray2(nums);// TiimeLimit Exceeded
		System.out.println(response2);

	}

}

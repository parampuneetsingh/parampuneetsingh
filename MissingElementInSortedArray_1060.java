
public class MissingElementInSortedArray_1060 {

	public static int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int l = nums[mid] - mid - k;
            if (l >= nums[0]) {
            	high = mid;
            } else {
            	low = mid + 1;
            };
        }
        return nums[0] + low + k - 1;
    }
	
	public static void main(String[] args) {
		int[] A = {4,7,9,10};
		int K = 3;
		System.out.println(missingElement(A, K));
	}

}

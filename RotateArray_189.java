
public class RotateArray_189 {

    public void rotate2(int[] nums, int k) {
        int[] ary = new int[nums.length];
            
        for (int i=0; i < nums.length; i++) {
            //ary[(nums.length - i - 1) % k] = nums[i];
        	ary[(k + i) % (nums.length)] = nums[i];
        }
    }
    
	public void rotate(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
        int t=0, l=0;
        
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i == k) {
                t = i;
            }
                l = t;
                while (l < i) {
                    swap(nums, l, i);
                    l++;
                }
            }
        }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
	public static void main(String[] args) {
		RotateArray_189 rotate = new RotateArray_189();
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate.rotate2(nums, k);
	}

}

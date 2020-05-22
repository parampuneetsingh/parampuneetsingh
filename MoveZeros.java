
public class MoveZeros {

    public void moveIntegers(int[] nums) {
        int j=0;
        for (int i = 0; i<nums.length-1;i++) {
            if (nums[i] == 0) {
                if (nums[i+1] != 0){
                    nums[j] = nums[i+1];
                    j++;
                    nums[i+1] = 0;
                }
            } else {
            	j++;
            }
        }
    }
    
	public static void main(String[] args) {
		int digits[] = {0,1,0,3,12};
		MoveZeros nums = new MoveZeros();
		nums.moveIntegers(digits);
		for (int i:digits) {
			System.out.println(i);
		}

	}

}

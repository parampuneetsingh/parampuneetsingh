import java.util.Arrays;

public class FirstMissingPositive_41 {

	public int firstMissingPositive(int[] nums) {
		int i = 0;
		if (nums.length == 0) {
			return 1;
		} else if (nums.length == 1) {
			return ++nums[0];
		}

		Arrays.sort(nums);
		while (nums[i] < 0) {
			i++;
		}
		for (; i < nums.length; i++) {
			if (nums[i] != i) {
				break;
				// return i;
			}
		}
		if (i == nums.length - 1) {
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,0};
		FirstMissingPositive_41 missingPositive = new FirstMissingPositive_41();
		int resp = missingPositive.firstMissingPositive(nums);
		System.out.println(resp);

	}

}

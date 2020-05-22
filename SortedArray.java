//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

public class SortedArray {

	public static void main(String[] args) {
		int nums[] = {1, 2};
		int arySize = nums.length;
		int k = 1;
		int tempAry[] = new int[arySize];

		for (int i = 0; i <= arySize - 1; i++) {
			tempAry[(i + k) % arySize] = nums[i];
		}
		for (int print : tempAry) {
			System.out.println(print);
		}
	}
}
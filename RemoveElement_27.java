
public class RemoveElement_27 {

	public int removeElement(int[] nums, int val) {
		int begin = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[begin++] = nums[i];
			}
		}
		return begin;
	}

	public static void main(String[] args) {

		RemoveElement_27 elem = new RemoveElement_27();
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		elem.removeElement(nums, val);
	}
}

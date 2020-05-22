import java.util.HashSet;

public class ArrayContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1 };
		ArrayContainsDuplicate_217 checkDup = new ArrayContainsDuplicate_217();
		// Solution1
		// checkDup.containsDuplicate(nums);
		// Solution2
		System.out.println(checkDup.containsDuplicate(nums));

	}

}

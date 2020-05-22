import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/contains-duplicate-ii/
//https://www.programcreek.com/2014/05/leetcode-contains-duplicate-ii-java/

public class ContainsDuplicateII_219 {

	//Preferred
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0) {
            return false;
        }
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
    //Taking lot of time
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		
		if (k == 0) return false;
		
		ArrayList<Integer> ary = new ArrayList<Integer>();
		
		for (int i=0; i < nums.length; i++) {
			if (ary.contains(nums[i])) {
				return true;
			} else {
				if (ary.size() > k - 1) {
					ary.remove(0);
					ary.add(nums[i]);
				} else {
					ary.add(nums[i]);
				}
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII_219 dup = new ContainsDuplicateII_219();
		//int[] nums = {0,5,1,2,3,1};
		//int k = 3;
		int[] nums = {99,99};
		int k = 2;
		dup.containsNearbyDuplicate(nums, k);
	}

}

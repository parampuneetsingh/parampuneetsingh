//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//https://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/

public class SearchRotatedSortedArrayII_81 {

	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[left] < nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]) {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left++;
			}
		}

		return false;
	}

	/*
	public boolean searchElement(int[] nums, int start, int end, int target) {
        if (nums.length == 0 || nums == null || start < 0 || end < 0 || (nums.length == 1 && nums[0] != target)) {
            return false;
        }
        int mid = (start + end) / 2;
        
        if (nums[mid] == target) {
            return true;
        }
        
        if (nums[start] < nums[mid]) {
        	if (target >= nums[start] && target < nums[mid]) {
        		return searchElement(nums, start, mid, target);
        	}
        	else {
        		return searchElement(nums, mid+1, end, target);
        	}
        } 
        else if (nums[start] > nums[mid]) {
        	if (target > nums[mid] && target <= nums[end]) {
        		return searchElement(nums, mid+1, end, target);
        	} else {
        		return searchElement(nums, start, mid-1, target);
        	}
        }
        else if (nums[start] == nums[mid]) {
        	if(nums[mid] != nums[end]) {
        		return searchElement(nums, mid+1, end, target);
        	} else {
        		boolean result = searchElement(nums, start, mid-1, target);
        		if(!result) {
                    return searchElement(nums, mid+1, end, target); //search right
                }else{
                    return result;
                }
        	}
        }
        
        return false;
    }
	
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        boolean response = searchElement(nums, start, end, target);
        System.out.println(response);
        return response;
    }*/

	public static void main(String[] args) {
		//int[] nums = { 2,5,6,0,0,1,2 };
		//int target = 0;
		int[] nums = { 1, 3 };
		int target = 3;
		SearchRotatedSortedArrayII_81 srsa = new SearchRotatedSortedArrayII_81();
		System.out.println(srsa.search(nums, target));
	}

}

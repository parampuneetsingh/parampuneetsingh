import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/

public class IntersectionofTwoArraysII_350 {

	public static int[] intersect(int[] nums1, int[] nums2) {
		int l = (nums1.length > nums2.length) ? nums1.length : nums2.length;
		int[] res = new int[l];
		int counter = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		for (int j = 0; j < nums2.length; j++) {
			if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
				res[counter] = nums2[j];
				counter++;
				map.put(nums2[j], map.get(nums2[j]) - 1);
			}
		}
		
		return Arrays.copyOf(res, counter);
	}

	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		intersect(nums1, nums2);
	}

}

//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int length = nums1.length - 1;

		while (m > 0 && n > 0) {
			if (nums2[n - 1] > nums1[m - 1]) {
				nums1[length--] = nums2[n - 1];
				n--;
			} else {
				nums1[length--] = nums1[m - 1];
				m--;
			}
		}

		while (m > 0) {
			nums1[length--] = nums1[m - 1];
			m--;
		}

		while (n > 0) {
			nums1[length--] = nums2[n - 1];
			n--;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		MergeSortedArray_88 MSA = new MergeSortedArray_88();
		MSA.merge(nums1, m, nums2, n);
	}

}

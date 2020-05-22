
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int L = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[L] = nums1[i];
				i--;
			} else {
				nums1[L] = nums2[j];
				j--;
			}
			L--;
		}
		if (j >= 0) {
			for (int k = 0; k <= j; k++) {
				nums1[k] = nums2[k];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		MergeSortedArray MSA = new MergeSortedArray();
		MSA.merge(nums1, m, nums2, n);
	}

}

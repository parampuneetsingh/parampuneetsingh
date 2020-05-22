//https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class MountainArray_852 {

	public int checkMountain(int[] A) {
		int low = 0;
		int high = A.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] < A[mid + 1]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		
		return low;
    }
	
	public static void main(String[] args) {
		MountainArray_852 ary = new MountainArray_852();
		int[] A = {0,2,1,0};
		ary.checkMountain(A);
	}
}
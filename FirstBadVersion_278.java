//https://leetcode.com/problems/first-bad-version/

public class FirstBadVersion_278 {

	public int firstBadVersion(int n) {
		int low = 1, high = n;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;

			if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		FirstBadVersion_278 findVersion = new FirstBadVersion_278();
		// Given n = 5, and version = 4 is the first bad version.

		findVersion.isBadVersion(3); // -> false
		findVersion.isBadVersion(5); // -> true
		findVersion.isBadVersion(4); // -> true

		// Then 4 is the first bad version.
	}

}

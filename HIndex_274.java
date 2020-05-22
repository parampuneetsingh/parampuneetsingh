import java.util.Arrays;

//https://leetcode.com/problems/h-index/

public class HIndex_274 {

	//Using Extra space
	public int hIndex2(int[] citations) {
		int n = citations.length;
		if (n == 0)
			return 0;
		int[] hindex = new int[n + 1];
		for (int val : citations) {
			if (val >= n)
				hindex[n]++;
			else
				hindex[val]++;
		}
		int sum = 0;
		int i = n;
		while (i > 0) {
			sum += hindex[i];
			if (i <= sum)
				return i;
			i--;
		}
		return 0;
	}

	public int hIndex(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		int low = 0, high = n - 1;
		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;

			if (citations[mid] < n - mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return n - low;
	}

	public static void main(String[] args) {
		HIndex_274 findIndex = new HIndex_274();
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(findIndex.hIndex(citations));
	}

}

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/

public class FindKClosestElements_658 {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		int left = 0;
		int right = arr.length - k;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		for (int i = left; i < left + k; i++)
			result.add(arr[i]);
		
		return result;
	}

	public static void main(String[] args) {
		FindKClosestElements_658 find = new FindKClosestElements_658();
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4, x = 3;
		System.out.println(Math.pow(2, 0));
		//find.findClosestElements(arr, k, x);
	}

}

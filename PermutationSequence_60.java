import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/permutation-sequence/
//https://www.youtube.com/watch?v=8Ed7wuVYs-I

public class PermutationSequence_60 {

	public void findAllPermutations(String num, String ans, PriorityQueue<String> minHeap) {
		if (num.length() == 0) {
			minHeap.add(ans);
			return;
		}

		for (int i = 0; i < num.length(); i++) {
			String t = num.substring(0, i) + num.substring(i + 1);
			findAllPermutations(t, ans + num.charAt(i), minHeap);
		}
	}

	//Giving Time Out for 
	public String getPermutation(int n, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<String>();

		String num = "";
		for (int i = 1; i <= n; i++) {
			num += i;
		}

		findAllPermutations(num, "", minHeap);

		while (--k > 0) {
			minHeap.poll();
		}

		return minHeap.peek();
	}

	public String getPermutation2(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();

		int[] fact = new int[n];
		fact[0] = 1;

		for (int i = 1; i < n; i++) {
			fact[i] = i * fact[i - 1];
		}

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		k--;
		String s = "";

		for (int i = n - 1; i >= 0; i--) {
			int index = k / fact[i];
			s = s + "" + list.remove(index);
			k = k % fact[i];
		}

		return s;
	}

	public static void main(String[] args) {
		PermutationSequence_60 findNum = new PermutationSequence_60();
		int n = 3, k = 3;
		System.out.println(findNum.getPermutation(n, k));

	}

}

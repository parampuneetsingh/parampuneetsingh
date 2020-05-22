import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=KE5Axm7uzok
//https://leetcode.com/problems/reverse-bits/

public class ReverseBits_190 {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>();
		
		int num = 43261596;
		int n = 32;
		int res = 0;
		
		while (n > 0) {
			lst.add(num&1);
			num = num >> 1;
			n--;
		}
		
		for (int i=0; i<lst.size(); i++) {
			res = res << 1;
			res = res | lst.get(i);
		}
		
		System.out.println(res);	
	}
}
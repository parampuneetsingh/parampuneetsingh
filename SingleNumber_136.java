
public class SingleNumber_136 {

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		 int a = 0;
	    for (int i : nums) {
	      a ^= i;
	    }
	    System.out.println(a);
	}

}

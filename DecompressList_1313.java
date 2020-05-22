import java.util.ArrayList;


public class DecompressList_1313 {

	 public int[] decompressRLElist(int[] nums) {
	        ArrayList<Integer> lst = new ArrayList<Integer>();
	        
	        int aSize = nums.length;
	        
	        for (int i=1; i < aSize; i++) {
	            int freq = nums[i-1];
	            int val = nums[i];
	            
	            for (int j=0; j < freq; j++) {
	                lst.add(val);
	            }
	            i++;
	        }
	    
	        int[] res = new int[lst.size()];
	        for (int i=0;i<lst.size();i++) {
				res[i] = lst.get(i);
			}
	        return res;
	    }
	 
	public static void main(String[] args) {
		DecompressList_1313 dComp = new DecompressList_1313();
		int[] nums = {1,2,3,4};
		int[] res = dComp.decompressRLElist(nums);
		for (int i:res) {
			System.out.println(i);
		}
	}

}

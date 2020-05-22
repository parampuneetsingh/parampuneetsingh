public class RemoveDuplicate {

	public int removeDuplicates(int[] A) {
	    if (A.length==0) return 0;
	    int j=0;
	    for (int i=0; i<A.length; i++)
	        if (A[i]!=A[j]) { 
	        	A[++j]=A[i];
	        }
	    return ++j;
	}
	
	public static void main(String[] args) {
		int[] arry = {0,0,1,1,1,2,2,3,3,4};
		RemoveDuplicate rmv = new RemoveDuplicate();
		System.out.println(rmv.removeDuplicates(arry));
	}
}

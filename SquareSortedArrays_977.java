
public class SquareSortedArrays_977 {

	public static int[] sortedSquares(int[] A) {
        int j=0;
        int l=A.length - 1;
        int[] resp = new int[A.length];
        while (j < l && A[j] < 0) {
            j++;
        }
        int temp=j-1;
        int counter=0;
        while(temp >= 0 && j < A.length) {
            if (A[temp] * A[temp] < A[j] * A[j]) {
                resp[counter++] = A[temp] * A[temp];
                temp--;
            } else {
                resp[counter++] = A[j] * A[j];
                j++;
            }
        }
        
        while (temp >= 0){
        	resp[counter++] = A[temp] * A[temp];
            temp--;
        }
        
        while (j < A.length){
        	resp[counter++] = A[j] * A[j];
            j++;
        }
        return resp;
    }
	
	public static void main(String[] args) {
		int[] nums = {-4,-1,0,3,10};
		sortedSquares(nums);
	}

}

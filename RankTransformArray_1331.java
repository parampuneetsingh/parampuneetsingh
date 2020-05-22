import java.util.ArrayList;
import java.util.List;


public class RankTransformArray_1331 {

	public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr;
        /*Arrays.sort(temp);
        */
        List<Integer> tempLst = new ArrayList<Integer>();
        
        tempLst.add(10);
        tempLst.add(20);
        tempLst.add(30);
        tempLst.add(40);
        int[] resp = new int[arr.length];
        for(int i=0; i < arr.length; i++) {
            resp[i] = tempLst.indexOf(arr[i]);
        }
        
        return resp;
    }
	
	public static void main(String[] args) {
		RankTransformArray_1331 transform = new RankTransformArray_1331();
		int[] nums = {40,10,20,30};
		transform.arrayRankTransform(nums);
	}

}

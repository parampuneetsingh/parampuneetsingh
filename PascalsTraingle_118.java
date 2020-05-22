import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle_118 {

	//Solution 1
	/*public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lstAry = new ArrayList<List<Integer>>();

		int start = 1;

		lstAry.add(0, new ArrayList<Integer>());
		lstAry.get(0).add(start);
		for (int j = 1; j < numRows; j++) {
			List<Integer> row = new ArrayList<Integer>();
			List<Integer> prevRow = lstAry.get(j - 1);
			row.add(start);
			for (int k = 1; k < j; k++) {
				row.add(prevRow.get(k - 1) + prevRow.get(k));
			}
			row.add(start);
			lstAry.add(row);
		}

		return lstAry;
	}*/
	
	//Solution 2
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        
        if (numRows == 0) {
            return lst;    
        }
        
        lst.add(0, new ArrayList<Integer>());
        lst.get(0).add(1);
        
        for (int i=1;i<numRows;i++) {
            lst.add(i, new ArrayList<Integer>());
            lst.get(i).add(1);
            for (int j=1; j<i;j++) {
                lst.get(i).add(lst.get(i-1).get(j-1) + lst.get(i-1).get(j));
            }
            lst.get(i).add(1);
        }
        
    return lst;
    }

	public static void main(String[] args) {
		PascalsTraingle_118 gen = new PascalsTraingle_118();
		gen.generate(5);
	}
}
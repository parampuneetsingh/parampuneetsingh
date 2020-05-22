
public class CountNegativeMatrix_1351 {

	 public int countNegatives(int[][] grid) {
	        int vertLen = grid[0].length-1 ;
	        int hrzLen = grid.length-1;
	        
	        int res = 0;
	        System.out.println();
	        for (int i=hrzLen; i>=0;i--) {
	            for (int j=vertLen; j>=0;j--) {
	              if (grid[i][j] < 0) {
	                  res++;
	              } else {
	                  break;
	              }
	            }
	        }
	        
	        return res;
	    }
	 
	public static void main(String[] args) {
		CountNegativeMatrix_1351 test = new CountNegativeMatrix_1351();
		int[][] grid = {{5,1,0},{-5,-5,-5}};
		test.countNegatives(grid);
	}

}

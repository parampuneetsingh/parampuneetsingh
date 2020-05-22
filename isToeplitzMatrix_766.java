
public class isToeplitzMatrix_766 {

	public static boolean isToeplitzMatrix(int[][] matrix) {
        int hrzSize = matrix.length;
        int vertSize = matrix[0].length;
        
        for (int i=0; i< hrzSize-1; i++) {
            for (int j=0; j<vertSize-1;j++) {
            if (matrix[i][j] != matrix[i+1][j+1]) {
                return false;
            }
          }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,1,2,3},
				{9,5,1,2}
		};
		isToeplitzMatrix(matrix);

	}

}

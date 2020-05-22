//https://leetcode.com/problems/rotate-image/

public class RotateImage_48 {

	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		/*int mat[][] = { {1, 2, 3},
	            		{4, 5, 6},
	            		{7, 8, 9} };*/
		int mat[][] = { {5, 1, 9, 11},
						{2, 4, 8, 10},
						{13, 3, 6, 7},
						{15, 14, 12, 16}};
		
		RotateImage_48 rotateMat = new RotateImage_48();		
		rotateMat.rotate(mat);
		for (int[] arr:mat) {
			for (int prt:arr) {
				System.out.print(prt + " ");	
			}
			System.out.println(" ");
		}
	}
}
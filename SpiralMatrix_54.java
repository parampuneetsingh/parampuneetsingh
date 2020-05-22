import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
//https://www.youtube.com/watch?v=BdQ2AkaTgOA

public class SpiralMatrix_54 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return res;
		}

		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		int size = matrix.length * matrix[0].length;

		while (res.size() < size) {
			for (int i = left; i <= right && res.size() < size; i++) {
				res.add(matrix[top][i]);
			}
			top++;
			for (int j = top; j <= bottom && res.size() < size; j++) {
				res.add(matrix[j][right]);
			}
			right--;
			for (int k = right; k >= left && res.size() < size; k--) {
				res.add(matrix[bottom][k]);
			}
			bottom--;
			for (int l = bottom; l >= top && res.size() < size; l--) {
				res.add(matrix[l][left]);
			}
			left++;
		}
		return res;
	}

	public static void main(String[] args) {
		
		/*  int[][] nums = {{1,2,3}, 
				  		  {4,5,6}, 
				  		  {7,8,9}};
		*/
		int[][] nums = { { 1, 2, 3, 4 }, 
						 { 5, 6, 7, 8 }, 
						 { 9, 10, 11, 12 } };
		SpiralMatrix_54 matrix = new SpiralMatrix_54();
		System.out.println(matrix.spiralOrder(nums).toString());
	}

}

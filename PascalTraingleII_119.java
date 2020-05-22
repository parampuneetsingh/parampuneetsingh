import java.util.ArrayList;
import java.util.List;

public class PascalTraingleII_119 {

	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> lstAry = new ArrayList<List<Integer>>();

		lstAry.add(new ArrayList<Integer>());

		lstAry.get(0).add(1);

		if (rowIndex == 0) {
			return lstAry.get(0);
		}

		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> prev = lstAry.get(i - 1);
			List<Integer> tempRow = new ArrayList<Integer>();

			tempRow.add(1);
			for (int j = 1; j < i; j++) {
				tempRow.add(prev.get(j - 1) + prev.get(j));
			}
			tempRow.add(1);
			lstAry.add(i, tempRow);
		}
		return lstAry.get(rowIndex);
	}

	public static void main(String[] args) {
		PascalTraingleII_119 gen = new PascalTraingleII_119();
		gen.getRow(3);

	}

}

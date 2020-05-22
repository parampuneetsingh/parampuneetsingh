import java.util.Random;

//https://leetcode.com/problems/implement-rand10-using-rand7/

public class ImplementRand10UsingRand7_470 {

	public int rand7() {
		Random rand = new Random();
		return rand.nextInt(7);
	}

	public int rand10() {
		boolean flag = true;
		int row, col, idx = 0;

		while (flag) {
			row = rand7();
			col = rand7();
			idx = col + (row - 1) * 7;

			if (idx <= 40) {
				flag = false;
			}
		}

		return 1 + (idx - 1) % 10;
	}

	public static void main(String[] args) {
		ImplementRand10UsingRand7_470 random = new ImplementRand10UsingRand7_470();
		System.out.println(random.rand10());
	}

}

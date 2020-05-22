
//Better Solution
//https://www.youtube.com/watch?v=mU0Uin1vBGg

public class PerformStringShifts {

	public String stringShift(String s, int[][] shift) {

		for (int[] shft : shift) {
			int direction = shft[0];
			int amount = shft[1];

			if (direction == 0) {
				for (int i = 0; i < amount; i++) {
					s = s.substring(1) + s.substring(0, 1);
				}
			} else {
				for (int i = 0; i < amount; i++) {
					s = s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {
		PerformStringShifts shifts = new PerformStringShifts();
		String s = "abcdefg";
		int[][] shift = { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		System.out.println(shifts.stringShift(s, shift));
	}
}

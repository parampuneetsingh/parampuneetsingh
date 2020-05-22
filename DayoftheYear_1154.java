//https://leetcode.com/problems/day-of-the-year/

public class DayoftheYear_1154 {

	public boolean isLeap(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 100 == 0)
			return false;
		if (year % 4 == 0)
			return true;
		return false;
	}

	public int dayOfYear(String date) {
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int numOfDays = 0;

		String[] splitDate = date.split("-");
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]);

		if (isLeap(year)) {
			days[1] = 29;
		}

		for (int i = 0; i < month - 1; i++) {
			numOfDays += days[i];
		}

		return numOfDays + Integer.parseInt(splitDate[2]);
	}

	public static void main(String[] args) {
		DayoftheYear_1154 days = new DayoftheYear_1154();
		String date = "2019-01-09";
		System.out.println(days.dayOfYear(date));
	}

}

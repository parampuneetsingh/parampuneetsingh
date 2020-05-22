import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/day-of-the-week/

public class DayoftheWeek_1185 {

	public String dayOfTheWeek(int day, int month, int year) {
		int daysCount = 0;

		for (int i = 1971; i < year; i++) {
			if (i % 4 == 0) {
				daysCount += 366;
			} else {
				daysCount += 365;
			}
		}

		for (int i = 1; i < month; i++) {
			if (i == 2) {
				if (year % 4 != 0) {
					daysCount += 28;
				} else {
					daysCount += 29;
				}
			} else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
				daysCount += 30;
			} else {
				daysCount += 31;
			}
		}

		daysCount += day;
		int dayOfWeek = daysCount % 7;

		Map<Integer, String> dayToNameMap = new HashMap<Integer, String>();

		// Starting from Thursday because 1-1-1971 was Friday, And -1 day makes it
		// Thursday
		dayToNameMap.put(0, "Thursday");
		dayToNameMap.put(1, "Friday");
		dayToNameMap.put(2, "Saturday");
		dayToNameMap.put(3, "Sunday");
		dayToNameMap.put(4, "Monday");
		dayToNameMap.put(5, "Tuesday");
		dayToNameMap.put(6, "Wednesday");

		return dayToNameMap.get(dayOfWeek);
	}

	public static void main(String[] args) {
		DayoftheWeek_1185 findDay = new DayoftheWeek_1185();
		int day = 19, month = 5, year = 2020;
		System.out.println(findDay.dayOfTheWeek(day, month, year));
	}

}

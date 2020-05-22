import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI_729 {

	TreeMap<Integer, Integer> map;

	public MyCalendarI_729() {
		map = new TreeMap<Integer, Integer>();
	}

	public boolean book(int start, int end) {

	    Map.Entry<Integer, Integer> beforeEnd = map.lowerEntry(end);
        if (beforeEnd != null && beforeEnd.getValue() > start) {
            return false;
        }
        map.put(start, end);
		return true;
	}

	public static void main(String[] args) {
		MyCalendarI_729 myCalendar = new MyCalendarI_729();
		/*myCalendar.book(10, 20);
		myCalendar.book(15, 25);
		myCalendar.book(20, 30);*/
		
		myCalendar.book(47, 50);
		myCalendar.book(33, 41);
		myCalendar.book(39, 45);
		myCalendar.book(33, 42);
		myCalendar.book(25, 32);
		myCalendar.book(26, 35);
		myCalendar.book(19, 25);
		myCalendar.book(3, 8);
		myCalendar.book(8, 13);
		myCalendar.book(18, 27);
	}
}

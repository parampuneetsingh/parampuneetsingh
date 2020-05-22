import java.util.HashSet;
import java.util.Set;

//https://www.lintcode.com/problem/next-closest-time/
//https://www.youtube.com/watch?v=99Gw7Hezii8

public class NextClosestTime_681 {

	public String nextClosestTime(String time) {
		int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
		minutes += Integer.parseInt(time.substring(3));

		HashSet<Integer> digits = new HashSet<Integer>();

		for (char c : time.toCharArray()) {
			if (Character.isDigit(c)) {
				digits.add(c - '0');
			}
		}

		while (true) {
			minutes = (minutes + 1) % (24 * 60);
			int[] nextTime = { minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10 };

			boolean isValid = true;
			for (int digit : nextTime) {
				if (!digits.contains(digit)) {
					isValid = false;
				}
			}

			if (isValid) {
				return String.format("%02d:%02d", minutes / 60, minutes % 60);
			}
		}

	}
	
	//Solution2
	 public String nextClosestTime2(String time) {
	        String[] splitTime = time.split(":");
	        Set<Character> uniqueNums = new HashSet<Character>();
	        
	        int hours = Integer.parseInt(splitTime[0]);
	        int minutes = Integer.parseInt(splitTime[1]);
	    
	        for (char c:time.toCharArray()) {
	            uniqueNums.add(c);    
	        }
	        
	        boolean found = false;
	        int total = hours * 60 + minutes;
	        
	        while(!found) {
	            total = (total + 1) % (24*60);
	            
	            found = true;
	            String s = String.format("%02d:%02d", total/60 , total%60);
	            for (char c: s.toCharArray()) {
	                if (!uniqueNums.contains(c)) {
	                    found = false;
	                    break;
	                }
	            }
	        }
	        
	        return String.format("%02d:%02d", total/60, total%60);
	    }

	public static void main(String[] args) {
		NextClosestTime_681 time = new NextClosestTime_681();
		//System.out.println(time.nextClosestTime2("19:34"));
		//Easy to understand solution2
		System.out.println(time.nextClosestTime2("23:59"));
	}

}

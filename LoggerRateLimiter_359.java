import java.util.Hashtable;

public class LoggerRateLimiter_359 {
	    
	class Logger {
	    
		Hashtable<String, Integer> map = new Hashtable<String, Integer>();
		
		boolean shouldPrintMessage(int timestamp, String message) {
			if (map.contains(message)) {
				int val = timestamp - map.get(message);
				map.put(message, timestamp);
				if (val > 10) {
					return true;
				} else {
					return false;
				}
			} else {
				map.put(message, timestamp);
				return true;
			}
	    }
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

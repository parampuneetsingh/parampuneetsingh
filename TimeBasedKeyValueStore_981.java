import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

	HashMap<String, TreeMap<Integer, String>> map;

	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore_981() {
		map = new HashMap<String, TreeMap<Integer, String>>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			map.put(key, new TreeMap<Integer, String>());
		}
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";

		TreeMap<Integer, String> m = map.get(key);
		Integer t = m.floorKey(timestamp);

		return (t == null) ? "" : m.get(t);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

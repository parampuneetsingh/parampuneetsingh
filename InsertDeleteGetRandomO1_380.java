import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//https://www.youtube.com/watch?v=iB6clONG2qU

public class InsertDeleteGetRandomO1_380 {

	HashMap<Integer, Integer> map;
	List<Integer> list;
	Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomO1_380() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());        
        list.add(val);
        
        return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int index = map.remove(val), size = list.size(), last = list.get(size - 1);

		if (last != val) {
			Collections.swap(list, index, size - 1); // Swap the index with last index to remove. Bcoz last give removal
														// in ArrayList is O(1)
			map.put(last, index);	//Update the chane in Map
		}
		
		list.remove(size - 1);
		return true;
		
		// map.remove(val);
		// return list.remove((Integer) val);
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (list.isEmpty()) {
			return 0;
		}
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
		// Init an empty set.
		InsertDeleteGetRandomO1_380 randomSet = new InsertDeleteGetRandomO1_380();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		randomSet.getRandom();
	}

}

import java.util.TreeMap;

//https://leetcode.com/problems/random-pick-with-weight/
//https://www.youtube.com/watch?v=v-_aEMtgnkI
//https://www.youtube.com/watch?v=KAZM4tsH8aI

public class RandomPickWithWeight_528 {

	private TreeMap<Integer, Integer> map;
	int[] wArray;
	private int sum;
	
	//Solution 1
	/*
	public RandomPickWithWeight_528(int[] w) {
		map = new TreeMap<Integer, Integer>();
		sum = 0;
		for (int i = 0; i < w.length; i++) {
			map.put(sum, i);
			sum += w[i];
		}
	}

	public int pickIndex() {
		int floor = (int) (Math.random() * sum);
		return map.floorEntry(floor).getValue();
	}
	*/
	
	public RandomPickWithWeight_528(int[] w) {
        wArray = new int[w.length];
        
        for(int i=0; i<w.length; i++) {
            sum += w[i];
            wArray[i] = sum;
        }
    }

	public int pickIndex() {
		int idx = (int) (Math.random() * sum);
		return binarySearch(idx + 1);
	}

	private int binarySearch(int val) {
		int low = 0, high = wArray.length - 1;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (wArray[mid] < val) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] w = { 4, 2 };
		RandomPickWithWeight_528 weight = new RandomPickWithWeight_528(w);
		weight.pickIndex();
		weight.pickIndex();
		weight.pickIndex();
		weight.pickIndex();
		weight.pickIndex();
	}

}

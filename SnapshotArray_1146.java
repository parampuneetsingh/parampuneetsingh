import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//https://leetcode.com/problems/snapshot-array/

public class SnapshotArray_1146 {

	int snap_id;

	List<TreeMap<Integer, Integer>> map;

	public SnapshotArray_1146(int length) {
		map = new ArrayList<TreeMap<Integer, Integer>>();

		for (int i = 0; i < length; i++) {
			map.add(i, new TreeMap<Integer, Integer>());
			map.get(i).put(0, 0);
		}

		snap_id = 0;
	}

	public void set(int index, int val) {
		map.get(index).put(snap_id, val);
	}

	public int snap() {
		return snap_id++;
	}

	public int get(int index, int snap_id) {
		return map.get(index).floorEntry(snap_id).getValue();
	}

	public static void main(String[] args) {
		/*SnapshotArray_1146 snapshotArr = new SnapshotArray_1146(3);
		snapshotArr.set(0,5);
		snapshotArr.snap();
		snapshotArr.set(0,6);
		snapshotArr.get(0,0);*/
		/*SnapshotArray_1146 snapshotArr = new SnapshotArray_1146(1);
		snapshotArr.set(0,4);
		snapshotArr.set(0,16);
		snapshotArr.set(0,13);
		snapshotArr.snap();
		snapshotArr.get(0,0);
		snapshotArr.snap();*/
		SnapshotArray_1146 snapshotArr = new SnapshotArray_1146(4);
		snapshotArr.snap();
		snapshotArr.snap();
		snapshotArr.get(3,1);
		snapshotArr.set(2,4);
		snapshotArr.snap();
		snapshotArr.set(1,4);
	}

}

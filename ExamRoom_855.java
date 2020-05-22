import java.util.TreeSet;

//https://leetcode.com/problems/exam-room/
//LeetCode Solution
public class ExamRoom_855 {

	TreeSet<Integer> set;
	int N;

	public ExamRoom_855(int N) {
		this.N = N;
		set = new TreeSet<Integer>();
	}

	public int seat() {
		int student = 0;
		if (set.size() > 0) {
			int distance = set.first();
			Integer prev = null;

			for (int n : set) {
				if (prev != null) {
					int d = (n - prev) / 2;

					if (d > distance) {
						distance = d;
						student = prev + d;
					}
				}
				prev = n;
			}

			if (N - 1 - set.last() > distance) {
				student = N - 1;
			}
		}

		set.add(student);
		return student;
	}

	public void leave(int p) {
		set.remove(p);
	}

	public static void main(String[] args) {
		ExamRoom_855 room = new ExamRoom_855(10);
		room.seat();
		room.seat();
		room.seat();
		room.seat();
		room.leave(4);
		room.seat();
	}

}

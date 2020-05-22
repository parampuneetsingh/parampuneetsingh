import java.util.LinkedList;
import java.util.Queue;

//https://github.com/openset/leetcode/tree/master/problems/design-compressed-string-iterator

public class DesignCompressedStringIterator_604 {

	Queue<int[]> queue = new LinkedList<int[]>();

	public DesignCompressedStringIterator_604(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            int j = i+1;
            while (j < n && s.charAt(j) - 'A' < 0) j++;
            queue.add(new int[]{s.charAt(i) - 'A',  Integer.parseInt(s.substring(i+1, j))});
            i = j;
        }
    }

	public char next() {
		if (queue.isEmpty())
			return ' ';
		int[] top = queue.peek();
		if (--top[1] == 0)
			queue.poll();
		return (char) ('A' + top[0]);
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public static void main(String[] args) {
		DesignCompressedStringIterator_604 iterator = new DesignCompressedStringIterator_604("L1e2t1C1o1d1e1");
		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.next(); // return 't'
		iterator.next(); // return 'C'
		iterator.next(); // return 'o'
		iterator.next(); // return 'd'
		iterator.hasNext(); // return true
		iterator.next(); // return 'e'
		iterator.hasNext(); // return false
		iterator.next(); // return ' '
	}

}

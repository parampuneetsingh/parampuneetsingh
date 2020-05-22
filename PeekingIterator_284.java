import java.util.Iterator;

//https://leetcode.com/problems/peeking-iterator/

public class PeekingIterator_284 {

	class PeekingIterator implements Iterator<Integer> {

		Iterator<Integer> itr;
		Integer peek;

		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			itr = iterator;

			if (itr.hasNext()) {
				peek = itr.next();
			}
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return peek;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer next = peek;
			peek = (itr.hasNext() == true) ? itr.next() : null;

			return next;
		}

		@Override
		public boolean hasNext() {
			return peek != null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
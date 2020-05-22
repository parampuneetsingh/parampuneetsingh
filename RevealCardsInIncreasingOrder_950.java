import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/reveal-cards-in-increasing-order/

public class RevealCardsInIncreasingOrder_950 {

	public static int[] deckRevealedIncreasing(int[] deck) {
		Deque<Integer> dque = new LinkedList<Integer>();
		int[] resp = new int[deck.length];

		Arrays.sort(deck);

		dque.add(deck[deck.length - 1]);

		for (int i = deck.length - 2; i >= 0; i--) {
			int last = dque.pollLast();
			dque.addFirst(last);
			dque.addFirst(deck[i]);
		}

		int n = 0;
		while (!dque.isEmpty()) {
			resp[n] = dque.pollFirst();
			n++;
		}

		return resp;
	}

	public static void main(String[] args) {
		int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
		deckRevealedIncreasing(deck);
	}

}

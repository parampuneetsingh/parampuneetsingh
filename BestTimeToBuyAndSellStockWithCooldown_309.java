
public class BestTimeToBuyAndSellStockWithCooldown_309 {

	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length <= 1)
			return 0;

		int n = prices.length;
		int[] p = new int[n];
		int cash = 0; // how much cash do i have on hand

		p[0] = 0; // no profit on day one
		cash = -prices[0]; // buy stock day one -> cash depleted, since i bought stock
		p[1] = Math.max(0, prices[1] - prices[0]); // can i already make profit by selling on day 2?
		cash = Math.max(cash, -prices[1]); // is the stock lower to day to buy ?

		// we have already evaluated for first 2 days stock
		for (int i = 2; i < n; i++) {
			// will i get more profit if i sell my stock today ?
			// if not , cool down -> take the profit from previous day
			p[i] = Math.max(p[i - 1], cash + prices[i]);

			// can i buy the stock today ? --> ONLY if its a cool down yesterday
			// if i buy my stock, mean previous day was cooldown
			// get the profit from day before to calculate the cash
			// profit - today's price --> gives total cash in hand
			// buy only if it works out better ( increases cash in hand)
			cash = Math.max(cash, p[i - 2] - prices[i]);
		}

		return p[n - 1];

	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(prices));
	}

}

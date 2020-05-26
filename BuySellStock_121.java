
public class BuySellStock_121 {

	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = 0;
		int max = 1;
		int length = prices.length;

		while (min < length && max < length) {
			if (prices[min] > prices[max]) {
				min = max;
				max++;
			} else {
				profit = Math.max(profit, prices[max] - prices[min]);
				max++;
			}
		}
		return profit;
	}

	public int maxProfit2(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}

		return max;
	}

	public static void main(String[] args) {
		BuySellStock_121 stock = new BuySellStock_121();
		// int[] prices = {7,1,5,3,6,4};
		int[] prices = { 1, 2 };
		stock.maxProfit(prices);
	}

}

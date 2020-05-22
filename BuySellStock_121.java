
public class BuySellStock_121 {

	 public int maxProfit(int[] prices) {
		 	int profit = 0;
	        int min = 0;
	        int max = 1;
	        int length = prices.length;
	        
	        while(min < length && max < length) {
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
	 
	public static void main(String[] args) {
		BuySellStock_121 stock = new BuySellStock_121();
		//int[] prices = {7,1,5,3,6,4};
		int[] prices = {1,2};
		stock.maxProfit(prices);
	}

}

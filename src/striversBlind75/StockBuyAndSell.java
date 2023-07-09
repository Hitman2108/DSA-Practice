package striversBlind75;

public class StockBuyAndSell {
	
	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};
		int n=prices.length;
		maxProfit(prices,n);
		maxProfitUsingTwoPointers(prices,n);
	}

	public static void maxProfitUsingTwoPointers(int[] prices, int n) {
		int maxProfit=0;
		int minPrice=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			minPrice=Math.min(minPrice, prices[i]);
			maxProfit=Math.max(maxProfit, prices[i]-minPrice);
		}
		System.out.println(maxProfit);
	}

	public static void maxProfit(int[] prices, int n) {
		int maxProfit=0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(maxProfit<prices[j]-prices[i]) {
					maxProfit=prices[j]-prices[i];
				}
			}
		}
		System.out.println(maxProfit);
	}

}

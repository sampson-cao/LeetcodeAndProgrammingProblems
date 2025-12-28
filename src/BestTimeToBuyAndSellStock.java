public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {

		//int tempMax = Integer.MIN_VALUE;
		int tempMin = Integer.MAX_VALUE;
		int highestProfit = 0;

        for (int price : prices) {

            int profit = price - tempMin;
            System.out.println("Temp max: " + price + " Temp min: " + tempMin);
            System.out.println("Profit: " + profit);
            if (profit > highestProfit) {
                highestProfit = profit;
            }

            if (price < tempMin) {
                tempMin = price;
            }
        }
		return highestProfit;
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};

		System.out.println(maxProfit(prices));

	}
}

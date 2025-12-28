import java.lang.reflect.Array;
import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {

		int[] localMaxes = new int[prices.length];
		int[] localMins = new int[prices.length];

		Arrays.fill(localMaxes, Integer.MIN_VALUE);
		Arrays.fill(localMins, Integer.MAX_VALUE);

		int tempMax = Integer.MIN_VALUE;
		int tempMin = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] > tempMax) {
				tempMax = prices[i];
			}
			else if (tempMax != Integer.MIN_VALUE){
				localMaxes[i - 1] = tempMax;
				tempMax = Integer.MIN_VALUE;
			}

			if (prices[i] < tempMin) {
				tempMin = prices[i];
			}
			else if (tempMin != Integer.MAX_VALUE) {
				localMins[i - 1] = tempMin;
				tempMin = Integer.MAX_VALUE;
			}
		}
		// edge case of the last price being a higher price/a maxima
		localMaxes[prices.length - 1] = prices[prices.length - 1];

		System.out.println("Local mins: " + Arrays.toString(localMins));
		System.out.println("Local maxes: " + Arrays.toString(localMaxes));

		int highestProfit = 0;
		int buyPrice = 0;
		boolean validTrade = false;
		for (int i = 0; i < prices.length; i++) {
			if (localMins[i] != Integer.MAX_VALUE) {
				buyPrice = localMins[i];
				validTrade = true;
			}
			if (validTrade) {

				for (int j = i; j < prices.length; j++) {

					if (localMaxes[j] == Integer.MIN_VALUE) {
						continue;
					}

					// sell price - buy price
					int profit = localMaxes[j] - buyPrice;

					if (profit > highestProfit) {
						highestProfit = profit;
					}
				}
				validTrade = false;
			}
		}

		return highestProfit;
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};

		System.out.println(maxProfit(prices));

	}
}

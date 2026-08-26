class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int buyPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        // [2, 9, 1, 3, 6, 10]
        for(int i=0; i<n; i++){

            int sellPrice = prices[i];
            int profit = sellPrice - buyPrice;

            if(profit > 0){
                if(profit > maxProfit) maxProfit = profit;
            }else{
                buyPrice = sellPrice; // buy at lower price
            }
        }

        return maxProfit;
    }
}

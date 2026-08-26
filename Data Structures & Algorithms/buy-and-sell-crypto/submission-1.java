class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int lastBuyPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        // [2, 9, 1, 3, 6, 10]
        for(int i=0; i<n; i++){

            if(prices[i] < lastBuyPrice){
                // update last buy price only if found lesser buy price
                lastBuyPrice = prices[i];
            }else if( (prices[i] - lastBuyPrice ) > maxProfit){
                // update profit only if more profit
               maxProfit = prices[i] - lastBuyPrice;
            }
             

        }
        return maxProfit;

    }
}

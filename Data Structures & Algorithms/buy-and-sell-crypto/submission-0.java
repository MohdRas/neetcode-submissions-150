class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int lastBuyPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        // [2, 9, 1, 3, 6, 10]
        for(int i=0; i<n; i++){

            if(prices[i] < lastBuyPrice){
                lastBuyPrice = prices[i];
            }else if( (prices[i] - lastBuyPrice ) > maxProfit){
               maxProfit = prices[i] - lastBuyPrice;
            }
             

        }
        return maxProfit;

    }
}

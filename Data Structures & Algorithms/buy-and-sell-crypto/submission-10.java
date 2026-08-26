class Solution {
    public int maxProfit(int[] prices) {
        // 2 pointer

        int n = prices.length;

        int start = 0; // buy at index 0
        int end = 1; // sell at index 1

        int maxProfit = 0;

        //[2, 9, 1, 3, 6, 10]
        while(end <n){
            // buying at start
            // selling at end
            int profit = prices[end] - prices[start];

            if(profit > 0){
                // profit
                if(profit > maxProfit) maxProfit = profit;
            }else{
                // buy at lower price
                start = end; 
            }

            end++; // sell at a new price
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // 2 pointer

        int n = prices.length;

        int start = 0; // buy at index 0
        int end = 1; // sell at index 1

        int maxProfit = 0;

        //[2, 9, 1, 3, 6, 10]
        while(start <= end && start < n && end <n){

            int profit = prices[end] - prices[start];

           

            if(profit < 0){
                // no profit > sell price < buy price
               start = end; // make sell price as buy price
               end++; // sell at new price
            }else{
                 // profit found 
                end++; // expand window  
                
                if(profit > maxProfit){
                    // profit update
                    maxProfit = profit;
                } 
            }


        }

        return maxProfit;


    }
}

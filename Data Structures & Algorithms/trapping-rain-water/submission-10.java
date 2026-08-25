class Solution {
    public int trap(int[] h) {

        int n= h.length;

        int start = 0;
        int end  = n - 1;

        int maxL = 0;
        int maxR = 0;

        int totalVol = 0;

        while( start < end){
            
            if(h[start] <= h[end]){
                // water will overflow ONLY to left side.

                if(h[start] > maxL){
                    // new maxL
                    maxL = h[start];
                }else{
                    // valley
                    totalVol = totalVol + maxL - h[start];
                }

                start++;

            }else{
                
                if(h[end] > maxR){
                    // new maxR
                    maxR = h[end];
                }else{
                    // valley
                    totalVol = totalVol + maxR - h[end];
                }

                end--;

            }


        }

        return totalVol;



    }
}
class Solution {
    public int trap(int[] h) {

        int totalWater = 0;
        
        int n = h.length;

        int[] leftMax = new int[n];
        leftMax[0] = 0; // no element left to the first element

        for(int i=1; i<n; i++){
            // previous LeftMax vs previous Element
            leftMax[i] = Math.max(leftMax[i-1], h[i-1]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = 0; // no element right to the last element

        for(int i=n-2; i>=0; i--){
            // previous rightMax vs previous Element
            rightMax[i] = Math.max(rightMax[i+1], h[i+1]);
        }

        for(int i=0; i<n; i++){

            // this could be negative 
            int v = Math.min(leftMax[i], rightMax[i])-h[i];

            if(v>0) 
                totalWater = totalWater + v;

        }

        return totalWater;


    }
}

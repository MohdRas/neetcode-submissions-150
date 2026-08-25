class Solution {
    public int maxArea(int[] heights) {

        // Input: height = [1,7,2,5,4,7,3,6]

        // Output: 36

        int n = heights.length;

        int start = 0;
        int end = n-1;

        int maxArea = 0;

        while( start < end ){
            
            int area = (end-start) * Math.min(heights[start], heights[end]);
            
            if(area > maxArea) maxArea = area;
            
            if(heights[start] <= heights[end]){
                // dont loose index of larger height
                start++;
            }else if(heights[start] > heights[end]){
                // dont loose index of larger height
                end--;
            }

        }

        return maxArea;


        
    }
}

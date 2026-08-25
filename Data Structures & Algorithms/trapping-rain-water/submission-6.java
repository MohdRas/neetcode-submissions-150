class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int totalWater = 0;

        // The two guards walk toward each other until they meet
        while (left < right) {
            
            // Step 1: Identify the bottleneck side
            if (height[left] < height[right]) {
                
                // We are working on the left side. 
                // Is the current building a new boundary wall, or a valley?
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // New tall wall, update boundary (holds no water)
                } else {
                    totalWater += leftMax - height[left]; // Valley! Add water.
                }
                left++; // Move left guard inward
                
            } else {
                
                // We are working on the right side.
                // Is the current building a new boundary wall, or a valley?
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // New tall wall, update boundary (holds no water)
                } else {
                    totalWater += rightMax - height[right]; // Valley! Add water.
                }
                right--; // Move right guard inward
                
            }
        }

        return totalWater;
    }
}
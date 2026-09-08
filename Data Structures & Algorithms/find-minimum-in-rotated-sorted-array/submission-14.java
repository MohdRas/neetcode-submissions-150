class Solution {
    public int findMin(int[] nums) {
        
        // seach space [0 to n-1]
        int start = 0;
        int end = nums.length -1;

        while( start < end){

            int mid = start + ( end - start)/2;

            if(nums[mid] > nums[end]){
                // unsorted part [mid to end]
                // "min element" would be in the right side of "mid"
                // As "mid" > "end" ( end is smaller than mid and we are looking for min element), so will move "start" to "mid+"
                start = mid + 1;
            }else{
                // nums[mid] <= nums[end]
                // sorted part [ mid to end]
                // "min element" would be in the left side of "mid"
                // It can be possible that "mid" is a smallest element because it is sorted from "mid" to "end"
                end = mid;
            }

        }

        return nums[end];
    }
}

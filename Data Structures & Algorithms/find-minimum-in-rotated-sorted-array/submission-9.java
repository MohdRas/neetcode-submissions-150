class Solution {
    public int findMin(int[] nums) {

        // min element would be in the unsorted part of the array.

        int start = 0;
        int end = nums.length - 1;

        while( start < end){

            int mid = start + ( end - start) /2;

            if(nums[mid] < nums[end]){
                // sorted part [mid to end]
                // min element would be in the left side but "mid" can be "smallest element" too
                // so we will include "mid" in the next seacrh space
                end = mid;
            }else{
                // unsorted part [start to mid]
                // min element would in the right side
                start = mid + 1;
            }

        }
        return nums[start];
    }
}

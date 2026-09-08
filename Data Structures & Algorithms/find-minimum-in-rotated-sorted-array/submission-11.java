class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length -1;

        while( start < end){

            int mid = start + ( end - start) / 2;

            if(nums[mid] > nums[end]){
                // unsorted part [mid to end]
                // "min element" would be in the right side of "mid"
                // As "mid" is strictly greater than "end" ( end is smaller than mid and we are looking for min element), we will move to the next element to the right.
                start = mid + 1;
            }else{
                // nums[mid] <= nums[end]
                // sorted part [ mid to end]
                // "min element" would be in the left side
                // as this part (mid to end) is sorted. It can be possible that "mid" is a smallest element.
                end = mid;
            }

        }

        return nums[end];
    }
}

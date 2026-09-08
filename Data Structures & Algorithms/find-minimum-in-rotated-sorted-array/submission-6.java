class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1; // min element always exists inside index(0) to index(n-1).

        while( start < end){

            int mid = start + ( end - start) /2;

            if(nums[mid] < nums[end]){
                // sorted > skip
                end = mid;
            }else{
                // unsorted
                start = mid + 1;

            }

        }

        return nums[start];


    }
}

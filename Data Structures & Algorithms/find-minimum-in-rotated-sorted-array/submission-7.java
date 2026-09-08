class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1; // min element always exists inside index(0) to index(n-1).

        //[1,2,3,4,5,6] - 0 rotation
        //[6,1,2,3,4,5] - 1 rotation
        //[5,6,1,2,3,4] - 2 rotation
        //[4,5,6,1,2,3] - 3 rotation
        //[3,4,5,6,1,2] - 4 rotation
        //[2,3,4,5,6,1] - 5 rotation
        //[1,2,3,4,5,6] - 6 rotation


        while( start < end){

            int mid = start + ( end - start) /2;

            if(nums[mid] < nums[end]){ // as all elements are unique so equal case does not exist
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

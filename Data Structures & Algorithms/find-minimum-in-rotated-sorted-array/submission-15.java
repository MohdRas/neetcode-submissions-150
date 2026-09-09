class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        //nums=[3,4,5,6,1,2]
        //6 1 2
        // 6 1


        while( start < end){

            int mid = start + ( end - start)/2;

            if(nums[mid] > nums[end]){
                start = mid + 1; // unsorted right part
            }else{
                // mid<=end
                end = mid; //sorted right part
            }

        }

        return nums[start];

    }
}

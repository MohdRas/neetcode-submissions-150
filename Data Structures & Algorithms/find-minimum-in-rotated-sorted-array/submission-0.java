class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        //nums=[3,4,5,6,1,2]

        while( start < end){

            int mid = start + ( end - start) / 2;

            System.out.println(nums[mid]);

            if(nums[mid] > nums[end]){

                start = mid + 1;

            }else{

                end = mid;
            }
        }

        return nums[start];

    }
}

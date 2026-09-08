class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length -1;

// [1,2,3,4,5,6] - 0 rotation
// [6,1,2,3,4,5] - 1 rotation
// [5,6,1,2,3,4] - 2 rotation
// [4,5,6,1,2,3] - 3 rotation
// [3,4,5,6,1,2] - 4 rotation
// [2,3,4,5,6,1] - 5 rotation
// [1,2,3,4,5,6] - 6 rotation

        while(start <= end){

            int mid = start + ( end - start)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<nums[end]){
                // sorted - right
                if(nums[mid] < target && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid;
                }

            }else{
                // sorted - left
               if(nums[start] <= target  && target < nums[mid]){
                    end = mid;
               }else{
                    start = mid + 1;
               }
            }

        }
        return -1;   
    }
}

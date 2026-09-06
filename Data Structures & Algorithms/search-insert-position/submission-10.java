class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        
        //int end = nums.length - 1;
        // target can be greater than element at index (n-1) then target will go to index n.
        int end = nums.length-1; // so search space - till nth index

        while( start <= end){

            int mid = start + ( end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(end == nums.length-1){
            return end+1;
        }
        return start;
    }
}
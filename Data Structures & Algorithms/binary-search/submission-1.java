class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1; // search space [ 0 to n-1]

        while( start <= end ){     // overlapping start & end

            int mid = start + ( end - start ) / 2;

            if(target == nums[mid]){
                return mid; // found in array
            }else if(target < nums[mid]){
                end = mid - 1; // target exists in left 
            }else{
                start = mid + 1; // target exists in right
            }

        }

        return -1; // not found in array
        
    }
}

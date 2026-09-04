class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;             // search space [0 to n]

        // why "n" because target can be bigger than all elements

        while( start < end ){              // no overlapping of start & end
            
            int mid = start + ( end - start ) / 2;

            if(target <= nums[mid]){      
                end = mid;    // eligible search space = [start to mid]        
                // mid-1 can be smaller than the target then target can not be at mid-1 so mid is the possible candidate for correct position
            }else if(target > nums[mid]){
                // eligible search space = [mid+1 to end]
                start = mid + 1;
            }

        }

        return start;
        
    }
}
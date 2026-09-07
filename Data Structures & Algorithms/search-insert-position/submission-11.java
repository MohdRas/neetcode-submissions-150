class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length; // Search space includes index `n` as a valid insertion position

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid;       // target can be greater than nums[mid-1], making mid the correct insertion position
            } else {
                start = mid + 1; // nums[mid] is too small; discard left half
            }
        }
        
        // by end of loop, start & end will be same.
        return start;
    }
}
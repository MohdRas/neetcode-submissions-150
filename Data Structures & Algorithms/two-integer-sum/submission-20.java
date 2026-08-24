class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Base case / Guard clause
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        // Map to store: <Actual Element, Index Original>
        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If we found the matching partner in our history
            if (visited.containsKey(complement)) {
                return new int[]{visited.get(complement), i};
            }

            // Otherwise, store current element and index into history
            visited.put(nums[i], i);
        }

        // Fallback if no solution exists (though constraints guarantee one)
        return new int[]{-1, -1};
    }
}
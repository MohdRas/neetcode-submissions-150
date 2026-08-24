class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            
            // 1. Skip duplicate starting numbers for the outer loop
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = nums[i];
            int start = i + 1;
            int end = n - 1;
            
            while (start < end) {
                int second = nums[start];
                int third = nums[end];
                int sum = first + second + third;

                if (sum == 0) {
                    finalList.add(Arrays.asList(first, second, third));

                    start++;
                    end--; 

                    // 2. Skip duplicates for the start pointer
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }

                    // 3. Skip duplicates for the end pointer
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }

                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return finalList;
    }
}
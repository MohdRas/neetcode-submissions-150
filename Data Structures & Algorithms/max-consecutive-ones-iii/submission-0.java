class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int start = 0, end = 0, maxConsecutiveOne = 0;

        int[] freq = new int[2];

        while( end < n){

            freq[nums[end]]++;

            // freq of end > allowed freq ( k)
            while(freq[0] > k){

                freq[nums[start]]--;
                start++;

            }

            // max of substring
            maxConsecutiveOne = Integer.max(maxConsecutiveOne, end - start + 1); 

            System.out.println(maxConsecutiveOne);

            end++;

        }

        return maxConsecutiveOne;
    }
}
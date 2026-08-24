class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longestConSeq = 0;

        Set<Integer> set = new HashSet<>(); // space o(n) 

        for(int i=0; i< n; i++){
            set.add(nums[i]);
        }
       

        for(int i=0; i<n; i++){ //time o(n)

            int num = nums[i];
            if (!set.contains(num - 1)) {
                int count = 0;
                while(set.contains(num)){
                    count++;
                    num++;
                }

                if(longestConSeq < count)
                    longestConSeq = count;
            }
        }

        return longestConSeq;
    }
}

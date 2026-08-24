class Solution {
    public int[] twoSum(int[] nums, int target) { 
    
        // SORTING will not work as it will loose the indices.

        // hashmap solution

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n ;i++){

            int complimentE = target - nums[i];

            if(!map.containsKey(complimentE)){
                map.put(nums[i], i);
            }else{

                return new int[]{map.get(complimentE), i};

            }
        }

        return new int[]{-1,-1};
        


        
    }
}
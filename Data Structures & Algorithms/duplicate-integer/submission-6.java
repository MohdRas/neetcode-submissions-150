class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        // memory set to find if already visited or not
        Set<Integer> memorySet = new HashSet<>();


        for(int i=0 ; i<nums.length ; i++){

            // if already visited return true
            if(memorySet.contains(nums[i])){
              return true;  
            }

            memorySet.add(nums[i]);
        }

        // not visited any elemeny twice so return false
        return false;

        // no arithmetic calculation so no out of limit exception.
        // time complexity = O(n), because traversing array once.
        // space complexity - O(n) , because Hashet can have max od n elements if no duplicate.
    }
}
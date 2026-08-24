class Solution {
    public boolean hasDuplicate(int[] nums) {
       // soring time -  o(n logn) 
       // traversing array time -  o(n)
       //  total time -  o(n)

       // space -  o(1)

       Arrays.sort(nums); // o(nlogn)

       int n = nums.length;

       for(int i=0; i<n-1; i++){ // o(n)
            if(nums[i]==nums[i+1]){
                return true;
            }
       }

       return false;



    }
}
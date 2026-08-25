class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> finalList = new ArrayList<>();

        //[-1,0,1,2, -1,  -4 ] 
        //           n-2, n-1, n

        int n = nums.length;

        // sorted
        Arrays.sort(nums);

        // n-2 for triplet
        for(int i=0; i<n-2; i++){

            // "Process the first valid one, then skip all the "previous" duplicates." (Skip redundancy).
            if (i > 0 && nums[i] == nums[i - 1]) continue;
                
            int start = i+1; // start will be next to (i)
            int end = n-1;

            while(start < end){

                if(nums[i] + nums[start] + nums[end] == 0){
                    // found triplet
                    finalList.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;

                    // "Process the first valid one, then skip all the "previous" duplicates." (Skip redundancy).
                    while (start < end && nums[start] == nums[start - 1]) start++;

                    // "Process the first valid one, then skip all the "previous" duplicates." (Skip redundancy).
                    while(start < end && nums[end]==nums[end+1]) end--;
                    

                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }

            }
            

        }

        return finalList;


    }
}
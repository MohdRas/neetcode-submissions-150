class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int start = 0;
        int end = 0;

        TreeMap<Integer, Integer> treemap = new TreeMap<>();

        List<Integer> list = new ArrayList<>();

        while( end < n){

            treemap.put(nums[end], treemap.getOrDefault(nums[end],0)+1);

            if( end - start + 1 == k){

                // find max & add to list
                list.add(treemap.lastKey());


                // remove start
                treemap.put(nums[start], treemap.get(nums[start])-1);

                if(treemap.get(nums[start]) == 0){
                    treemap.remove(nums[start]);
                }

                start++;

            }

            end++;

        }

        return list.stream().mapToInt(i->i).toArray();


        
    }
}

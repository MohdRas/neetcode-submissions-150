class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int start = 0;
        int end = 0;

        TreeMap<Integer, Integer> treemap = new TreeMap<>();

        List<Integer> list = new ArrayList<>();

        while( end < n){

            int endElement = nums[end];
            treemap.put(endElement, treemap.getOrDefault(endElement,0)+1);

            if( end - start + 1 == k){

                // find max & add to list
                list.add(treemap.lastKey());


                // remove start
                int startElement = nums[start];
                treemap.put(startElement, treemap.get(startElement)-1);

                if(treemap.get(startElement) == 0){
                    treemap.remove(startElement);
                }

                start++;

            }

            end++;

        }

        return list.stream().mapToInt(i->i).toArray();


        
    }
}

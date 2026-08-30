class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int start = 0, end = 0, maxfruits = 0;

        // frequency of each fruit
        Map<Integer, Integer> freq = new HashMap<>();

        while( end < n){

            // counting freq of each fruit
            freq.put(fruits[end], freq.getOrDefault(fruits[end], 0)+1);

            // as long as bucket size > 2
            while(freq.size() > 2){

                // reduce frequency by 1
                freq.put(fruits[start], freq.get(fruits[start]) - 1);

                // remove fruit if frequency is 0
                if(freq.get(fruits[start]) == 0){
                    freq.remove(fruits[start]);
                }

                // move start
                start++;
            }

            // max fruits ( current max, window size)
            maxfruits = Integer.max(maxfruits, end - start + 1);

            // move end
            end++;
            
        }

        return maxfruits;
        
    }
}
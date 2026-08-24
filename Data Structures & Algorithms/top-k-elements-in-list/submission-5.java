class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // convert array into frequency map
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length ; i++){
            int freq = 0;
            if(map.containsKey(nums[i])){
                freq = map.get(nums[i]);
            }
            map.put(nums[i], ++freq);
        }

        // convert frequency map to array of lists

        List[] freqArray = new ArrayList[nums.length];

        for(Integer key : map.keySet()){
            Integer frequency = map.get(key);

            List<Integer> list = new ArrayList<>();

            if(freqArray[frequency-1] != null){
                list = freqArray[frequency-1];
            }
            
            list.add(key);
            freqArray[frequency-1] = list;
        }

        int[] finalResult = new int[k];
        int count = 0;
        for( int i=freqArray.length-1; i>=0; i--){
           if(freqArray[i] != null){
                for(int j=0; j<freqArray[i].size(); j++){
                    finalResult[count++] = (Integer)freqArray[i].get(j);
                    if(count==k){
                        return finalResult;
                    }
                }
           }
        }

        return finalResult;

        // iterate array and keep counting until k
        // store in array of size k
        // return array.
    }
}

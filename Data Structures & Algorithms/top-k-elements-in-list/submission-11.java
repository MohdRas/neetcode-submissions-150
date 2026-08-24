class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // 1. Build Frequency Map (1 line using getOrDefault)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Build Buckets (Size n + 1 so Index == Frequency)
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            // 1 line list initialization
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // 3. Extract Top K (Reading buckets backward)
        int[] result = new int[k];
        int count = 0;
        
        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[count++] = num;
                    if (count == k) return result; // Stop exactly when we hit K
                }
            }
        }
        
        return result;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            // 1. Build Frequency Array
            int[] alphabet = new int[26];
            for (char ch : strs[i].toCharArray()) {
                alphabet[ch - 'a']++;
            }

            // 2. Generate Signature instantly
            String strKey = Arrays.toString(alphabet);

            // 3. Group
            List<String> myList = map.getOrDefault(strKey, new ArrayList<>());
            myList.add(strs[i]);
            map.put(strKey, myList);
        }

        return new ArrayList<>(map.values());
    }
}
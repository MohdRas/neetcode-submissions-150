class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // sorted string
        for(int i=0; i<strs.length; i++){

            String originalStr = strs[i];

            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            List<String> anagrams = new ArrayList<>();

            if(map.containsKey(sortedStr)){
                anagrams = map.get(sortedStr);
            }

            anagrams.add(originalStr);
            map.put(sortedStr, anagrams);

            

        }

        //convert map list
        return new ArrayList<>(map.values());

    }
}

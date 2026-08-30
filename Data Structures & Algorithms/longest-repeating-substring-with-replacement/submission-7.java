class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int start = 0, end = 0, longestSubstring = 0;

        // frequency of each character
        int[] freq = new int[26];

        int maxFreq = 0;

        while(end < n){

            int endIndex = s.charAt(end) - 'A';
            freq[endIndex]++;

            maxFreq = Math.max(maxFreq, freq[endIndex]);

            while((end -start + 1) - maxFreq > k){
                int startIndex = s.charAt(start) - 'A';
                freq[startIndex]--;
                start++;
            }

            longestSubstring = Math.max(longestSubstring, end - start + 1);

            end++;


        }

        return longestSubstring;
    }
}

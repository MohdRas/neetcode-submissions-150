class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int start = 0, end = 0, longestSubstring = 0;

        // frequency of each character
        int[] freq = new int[26];

        int maxFreq = 0;

        while(end < n){

            // counting frequency of each character
            int endIndex = s.charAt(end) - 'A';
            freq[endIndex]++;

            // find max frequency from characters in window ( start to end)
            maxFreq = Math.max(maxFreq, freq[endIndex]);

            // (end -start + 1) - maxFreq => characters to be replaced
            // but we can replace max of k characters
            // so more than k replaceable characters make the window invalid

            // validating the window
            while((end -start + 1) - maxFreq > k){

                // reducing frequency of "start" characters
                int startIndex = s.charAt(start) - 'A';
                freq[startIndex]--;
                // move "start" forward
                start++;
            }

            // finding logest substring with upto K replacements
            longestSubstring = Math.max(longestSubstring, end - start + 1);

            // move "end" forward
            end++;
        }

        return longestSubstring;
    }
}

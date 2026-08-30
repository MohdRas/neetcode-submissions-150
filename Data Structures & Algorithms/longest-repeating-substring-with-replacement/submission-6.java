class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        
        int start = 0;
        int end = 0;

        // keeping freq of each character
        int[] freq = new int[26];

        // max freq of any character in a window ( start - end)
        int maxFreq = 0;

        int maxsubstring = 0;

        while( end < n){

            // keeping frequency of "end"
            int endIndex = s.charAt(end) - 'A';
            freq[endIndex]++;

            // find max freq
            if(freq[endIndex] > maxFreq){
                maxFreq = freq[endIndex];
            }

            // window size = end - start + 1
            // replacement needed = (windowSize - maxFreq)
            // max replacement = k
            while(end - start + 1 - maxFreq > k){
                int startIndex = s.charAt(start) - 'A';
                freq[startIndex]--; // reduce frequency of "start"
                start++; // move "start"

            }

            if(end - start + 1 > maxsubstring){
                maxsubstring = end - start + 1;
            }

            end++;
        }

        return maxsubstring;

    }
}

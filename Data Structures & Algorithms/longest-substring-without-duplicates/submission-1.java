class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int start = 0;
        int end = 0;
        int largestsubstring = 0;

        int[] freq = new int[128];

        while( end < n){

            freq[s.charAt(end)]++;

            while( freq[s.charAt(end)] > 1){

                freq[s.charAt(start)]--;
                start++;    

            }

            if(end - start + 1 > largestsubstring){
                largestsubstring = end -start +1;
            }

            end++;


        }

        return largestsubstring;

    }
}

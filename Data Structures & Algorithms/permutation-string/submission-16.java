class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // I will use only one array to frequency update 
        // catch : all elements of s2 ( exists in s1 or not) will be part of frequency count array

        int n1 = s1.length();
        int n2 = s2.length();

        int[] freq = new int[26];

        for(int i=0; i<n1; i++){

            int index = s1.charAt(i) - 'a';

            freq[index]++;

        }

        int start = 0;
        int end = 0;

        while( end < n2){

            int indexEnd = s2.charAt(end) - 'a';
            freq[indexEnd]--;

            if(end - start + 1 == n1){

                boolean permutation = true;

                for(int i=0; i<freq.length; i++){
                    if(freq[i] != 0){
                        permutation = false;
                    }
                }

                if(permutation){
                    return permutation;
                }

                int indexStart = s2.charAt(start) - 'a';
                freq[indexStart]++;

                start++;

            }

            end++;

        }

        return false;

        
    }
}

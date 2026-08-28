class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // 2 arrays for frequency
        // one array is used to track & update frequency
        // another array is to check if character from s2 exists in s1

        int n1 = s1.length();
        int n2 = s2.length();

        int[] freq = new int[26];
        int[] existsInS1 = new int[26];

        for(int i=0; i<n1; i++){

            int index = s1.charAt(i) - 'a';
            
            freq[index]++;
            existsInS1[index]++;

        }

        int start = 0;
        int end = 0;

        while(end < n2){
            
            // head exists in s1 and then decrement
            int indexEnd = s2.charAt(end) - 'a';
            if(existsInS1[indexEnd] > 0){
                freq[indexEnd]--;
            }

            if( end - start + 1 == n1){

                boolean permuation = true;

                for(int i=0; i<26; i++){

                    if(freq[i] != 0){
                        permuation = false;
                        break;
                    }

                }
                
                if(permuation){
                    return permuation;
                }

                 // tail exists in s1 and then increment
                int indexStart = s2.charAt(start) - 'a';
                if(existsInS1[indexStart] > 0){
                    freq[indexStart]++;
                }

                start++;
                
            }

            end++;


        }

        return false;






    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        int[] freqCount = new int[26];

        // 1. Initialize frequency array with s1 characters
        for(int i = 0; i < n1; i++){
            freqCount[s1.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = 0;

        // 2. The while loop (Head traverses)
        while(end < n2){

            // 3. Update state based on Head (subtract incoming char)
            freqCount[s2.charAt(end) - 'a']--;

            // 4. Validate Window when size matches n1
            if(end - start + 1 == n1){
                
                boolean permutation = true;
                for(int i = 0; i < 26; i++){
                    if(freqCount[i] != 0){
                        permutation = false;
                        break;
                    }
                }  

                if(permutation){
                    return true;
                } 

                // Prepare to slide: restore the outgoing character
                freqCount[s2.charAt(start) - 'a']++;
                start++;
            }

            // 5. Head always takes its step forward at the END of the loop
            end++;
        }

        return false;
    }
}
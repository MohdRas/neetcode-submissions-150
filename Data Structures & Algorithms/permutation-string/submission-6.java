class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        int[] freqCount = new int[26];

        for(int i=0; i<n1; i++){

            freqCount[s1.charAt(i)-'a']++;

        }

        boolean permutaion = false;

        int start = 0;
        int end = 0;

        while(end < n2){

            freqCount[s2.charAt(end)-'a']--;

            if(end - start + 1 == n1){

                permutaion = true;
                for(int i=0; i<26; i++){

                    if(freqCount[i]!=0){
                        permutaion = false;
                        break;
                    }

                }  

                if(permutaion){
                    return true;
                } 

                freqCount[s2.charAt(start)-'a']++;

                start++;

            }

            end++;

        }

        return false;
    }
}
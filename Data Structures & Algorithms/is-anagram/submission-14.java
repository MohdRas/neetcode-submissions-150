class Solution {
    public boolean isAnagram(String s, String t) {

       
        // SORTING o(nlogn) + o(1)

        // make it => o(1) + o(1)


        int sN = s.length();
        int tN = t.length();

        if(sN != tN) return false;


        int[] ascii = new int[26];

        char[] scharA = s.toCharArray();
        char[] tcharA = t.toCharArray();

        for( int i = 0; i< sN; i++){

            ascii[scharA[i]-'a']++;
            ascii[tcharA[i]-'a']--;

        }

        for(int i=0; i<ascii.length; i++){
            if(ascii[i] !=0)
                return false;
        }

        return true;

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        // as there is no contraint on length of each so i will add

        if(s.length() != t.length()){
            return false;
        }

        int length = s.length();

        // as strings are in lowercase
        // still I will convert them to lowercase first.

        char charS[] = s.toCharArray();
        char charT[] = t.toCharArray();

        // frequence array
        int[] frequency = new int[26]; // 26 size because english character has max size 26

        // traverse first string s & t

        for (int i=0; i<length; i++){
            
            int sChar = charS[i]-'a';
            int tChar = charT[i]-'a';

            frequency[sChar]++;
            frequency[tChar]--;
        }

        for(int i=0; i<frequency.length; i++){
            if(frequency[i] !=0){
                return false;
            }
        }

        return true;
        
        // time = O(n)
        // space = O(26) = O(1)


    }
}

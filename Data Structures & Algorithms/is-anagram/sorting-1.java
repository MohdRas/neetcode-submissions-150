class Solution {
    public boolean isAnagram(String s, String t) {

            // string to char-array
            char[] schArray = s.toCharArray();

            // sort
            Arrays.sort(schArray); // o(nlogn)

            // char-array to string
            s = new String(schArray); 


            // string to char-array
            char[] tchArray = t.toCharArray();

            // sort
            Arrays.sort(tchArray); // o(nlogn)

            // char-array to string
            t = new String(tchArray); 

            if(s.compareTo(t)==0){
                return true;
            }

            return false;



    }
}

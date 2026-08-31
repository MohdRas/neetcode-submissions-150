class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            // open bracket -> push closed one.
            if(ch == '(') stack.push(')'); 
            if(ch == '{') stack.push('}'); 
            if(ch == '[') stack.push(']'); 

            // closed bracket
            if(ch == ')' || ch == '}' || ch == ']' ){

                if(stack.isEmpty()){ // closed bracket has nothing to match with.
                    return false;
                }
                if(stack.pop() != ch){ // closed bracket isnot equal to top of the stack.
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}

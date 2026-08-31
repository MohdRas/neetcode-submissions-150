class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch == '(') stack.push(')'); // open bracket -> push closed one

            if(ch == '{') stack.push('}'); // open bracket -> push closed one

            if(ch == '[') stack.push(']'); // open bracket -> push closed one

            // closed bracket
            if(ch == ')' || ch == '}' || ch == ']' ){

                if(stack.isEmpty()){ // ch has nothing to match with
                    return false;
                }
                if(stack.pop() != ch){ // ch is not equal to top of the stack
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}

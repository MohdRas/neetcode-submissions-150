class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            // open bracket
            if(ch == '(') stack.push(')'); // push closed one
            if(ch == '{') stack.push('}'); // push closed one
            if(ch == '[') stack.push(']'); // push closed one

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

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        
        for(String str : tokens){
            // operators
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") ){

                int second = stack.pop();
                int first = stack.pop();

                if(str.equals("+")){
                    stack.push(first + second);
                }
                if(str.equals("-")){
                    stack.push(first - second);
                }
                if(str.equals("*")){
                    stack.push(first * second);
                }
                if(str.equals("/")){
                    stack.push(first / second);
                }

            }else{
                stack.push(Integer.parseInt(str));
            }

        }

        return stack.peek();
    }
}

class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        
        // first value
        if(stack.isEmpty()){

            stack.push(new int[]{val, val});

        }else{

            int previousMin = stack.peek()[1];
            int minValue = Math.min(previousMin, val);
            stack.push(new int[]{val, minValue});

        }
        
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
        
    }
}

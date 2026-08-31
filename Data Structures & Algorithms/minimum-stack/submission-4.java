class MinStack {

    // array of size 2 = [value, min-value]
    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        
        // first value
        if(stack.isEmpty()){

            stack.push(new int[]{val, val}); // current value is "min value"

        }else{

            int previousMin = stack.peek()[1]; 
            int minValue = Math.min(previousMin, val); // min of "current" and "previous"

            stack.push(new int[]{val, minValue});

        }
        
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek()[0]; // 0th index has value
    }
    
    public int getMin() {
        return stack.peek()[1]; // 1th index has min value
        
    }
}

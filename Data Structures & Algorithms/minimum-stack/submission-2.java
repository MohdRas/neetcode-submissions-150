class MinStack {

    Stack<Integer> values;
    Stack<Integer> mins;

    public MinStack() {
        // values = push input values as they are coming
        values = new Stack<>();

        // find min of "min of previous values" and "current value"
        mins = new Stack<>();
    }
    
    public void push(int val) {

        // first value
        if(values.isEmpty()){
            values.push(val);
            mins.push(val);
        }else{
            values.push(val);

            // "min of previous values"
            int previousMin = mins.peek();
            // find min of "min of previous values" and "current value"
            mins.push(Math.min(val, previousMin)); 
        }
        
    }
    
    public void pop() {
        // not empty check
        
        // pop from both
        if(!values.isEmpty()){
            values.pop();
        }
        if(!mins.isEmpty()){
            mins.pop();
        }
    }
    
    public int top() {
        // top only from "values" stack

        return values.peek();    // no need of empty check
    }
    
    public int getMin() {
        // min only from "mins" stack

        return mins.peek();      // no need of empty check
    }
}

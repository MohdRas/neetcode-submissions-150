class MinStack {

    Stack<Integer> values;
    Stack<Integer> mins;

    public MinStack() {
        values = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {

        if(values.isEmpty()){
            values.push(val);
            mins.push(val);
        }else{
            values.push(val);
            int previousMin = mins.peek();
            mins.push(Math.min(val, previousMin)); 
        }
        
    }
    
    public void pop() {

        if(!values.isEmpty()){
            values.pop();
        }
        if(!mins.isEmpty()){
            mins.pop();
        }
        
    }
    
    public int top() {
        return values.peek();    
    }
    
    public int getMin() {
        return mins.peek();
    }
}

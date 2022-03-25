class MinStack {
    //Time O(N)
    //Space O(N)
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    int min = Integer.MAX_VALUE;
    public void push(int val) {
        if(min >= val)
        {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.pop())
        {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
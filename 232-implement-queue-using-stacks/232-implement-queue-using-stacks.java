class MyQueue {

    //Time O(N)
    //Space O(N)
    Stack<Integer> stack , Q_stack;
    public MyQueue() {
        stack = new Stack<>();
        Q_stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(Q_stack.isEmpty())
        {
            while(!stack.isEmpty())
            {
                Q_stack.push(stack.pop());
            }
        }
        return Q_stack.pop();
    }
    
    public int peek() {
        if(Q_stack.isEmpty())
        {
            while(!stack.isEmpty())
            {
                Q_stack.push(stack.pop());
            }
        }
        return Q_stack.peek();
    }
    
    public boolean empty() {
        return (Q_stack.isEmpty() && stack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(!st2.isEmpty()) return st2.pop();
        
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    public int peek() {
        if(!st2.isEmpty()) return st2.peek();
        
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}


class MyStack {
    
    Queue<Integer> main, aux;
    int size, top;
    
    public MyStack() {
        this.main = new LinkedList<>();
        this.aux = new LinkedList<>();
        this.size = 0;
        this.top = -1;
    }
    
    public void push(int x) {
        main.add(x);
        top = x;
        size++;
    }
    
    public int pop() {
        while(main.size() > 1){
            if(main.size() == 2) top = main.peek();
            aux.add(main.poll());
        }
        int ans = main.poll();
        size--;
        while(!aux.isEmpty()) main.add(aux.poll());
        
        return ans;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
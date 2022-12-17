class CustomStack {
    
    private Deque<Integer> stack = new ArrayDeque<>();
    int max = 0 ;

    public CustomStack(int maxSize) {
        max = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < max)
            stack.push(x);
    }
    
    public int pop() {
        if(stack.isEmpty())
            return -1;
        return stack.pop();
    }
    
    public void increment(int k, int val) {
        Deque<Integer> current = new ArrayDeque<>();
        while(!stack.isEmpty()){
            current.push(stack.pop());
        }
        k = Math.min(k, current.size());
        while(k > 0){
            k--;
            stack.push(val + current.pop());
                
        }
        
        while(!current.isEmpty()){
            stack.push(current.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
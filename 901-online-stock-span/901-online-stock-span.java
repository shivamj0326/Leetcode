class StockSpanner {
    
    class Pair{
        int first;
        int second;
        
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    private Deque<Pair> stack;
    

    public StockSpanner() {
        stack = new ArrayDeque<Pair>();
    }
    
    public int next(int price) {
        int count = 0 ;
        if(stack.size() != 0){
            while(stack.size() > 0 && stack.peek().first <= price){
                count += stack.poll().second;
            }
        }
        
        stack.push(new Pair(price, count + 1));  
        return count + 1;
    }
    
   
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
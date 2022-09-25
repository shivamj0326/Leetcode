class Solution {
    
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] ans = new int[n];
        
        Deque<Pair> stack = new ArrayDeque<>();
        
        for(int i = n - 1 ; i >= 0 ; i--){
            
            int x = temperatures[i];
            int count = 0 ;
            
            if(stack.size() == 0){
                count = 0;
            }    
            else if(stack.peek().first > x){
                count = 1;
            }    
            else{
                while(stack.size() > 0 && stack.peek().first <= x){
                    count += stack.poll().second;
                }
                if(stack.size() > 0)
                    count++;
                else
                    count = 0 ;
            }
            
            stack.push(new Pair(x, count));  
            ans[i] = count;
        }
        
        return ans;
        
        
    }
}
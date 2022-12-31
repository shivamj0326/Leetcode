class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int n = heights.length;
        
        int[] res = new int[n];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && heights[i] > stack.peek()){
                stack.pop();
                res[i]++;
            }
            
            if(!stack.isEmpty()){
                res[i]++;
            }
            stack.push(heights[i]);
        }
        
        return res;
    }
}


    
    
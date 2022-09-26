class Solution {
    
    class Pair{
        int first;
        int second;
        
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = -1;
        int[] maxi = new int[n];
        
        
        
        Deque<Pair> stackRight = new ArrayDeque<>();
        
        Deque<Pair> stackLeft = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            int x = heights[i];
            int count = 1 ;
            
            if(stackLeft.size() == 0){
               
            }
            else if(stackLeft.peek().first < x){
                
            }
            else{
                while(stackLeft.size() > 0 && stackLeft.peek().first >= x){
                    count += stackLeft.poll().second;
                }
            }
            
            stackLeft.push(new Pair(x, count));
            maxi[i] += count;
        }
        
        for(int i = n - 1 ; i >= 0 ; i--){
            int x = heights[i];
            int count = 1 ;
            
            if(stackRight.size() == 0){
                
            }
            else if(stackRight.peek().first < x){
                
            }
            else{
                while(stackRight.size() > 0 && stackRight.peek().first >= x){
                    count += stackRight.poll().second;
                }
                
            }
            
            stackRight.push(new Pair(x, count));
            maxi[i] += count;
               
        }
        
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, (maxi[i] - 1) * heights[i]);
        }
        return max;
    }
}
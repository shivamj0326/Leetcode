class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<int[]> capitals = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profits = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int i = 0 ; i < capital.length; i++){
            capitals.offer(new int[]{capital[i], profit[i]});
        }
        
        for(int i = 0 ; i < k ; i++){
            while(!capitals.isEmpty() && capitals.peek()[0] <= w){
                profits.add(capitals.poll());
            }
            
            if(profits.isEmpty())
                break;
            
            w += profits.poll()[1];
        }
        
        return w;
    }
}
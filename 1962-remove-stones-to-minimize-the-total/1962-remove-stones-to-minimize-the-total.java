class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : piles){
            sum += i;
            q.offer(i);
        }
        
        while(k-- > 0){
            int x = q.poll();
            sum -= x/2;
            x = x - x/2 ;
            q.offer(x);
            
        }
        
        return sum;
    }
}
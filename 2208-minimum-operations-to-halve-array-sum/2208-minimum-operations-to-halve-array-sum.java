class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        int count = 0 ;
        for(int i : nums){
            sum += (double)i;
            q.offer((double)i);
        }
        double half = sum/2;
        
        while(sum > half){
            double x = q.poll();
            
            sum -= x/2;
            x = x - x/2;
            q.offer(x);
            count++;
        }
        
        return count;
    }
}
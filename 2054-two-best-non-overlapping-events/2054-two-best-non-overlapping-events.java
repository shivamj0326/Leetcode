class Solution {

    public int maxTwoEvents(int[][] events) {
        int n = events.length, rmax = 0, max = 0 ;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int[] event : events){
            while(!q.isEmpty() && q.peek()[1] < event[0]){
                max = Math.max(max, q.peek()[2]);
                q.poll();
            }
            
            rmax = Math.max(rmax, max + event[2]);
            q.offer(event);
            
        }
   
        return rmax;
    
    }
}

 
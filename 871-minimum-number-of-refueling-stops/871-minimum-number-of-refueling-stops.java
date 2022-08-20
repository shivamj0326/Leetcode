class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        if(tank > target)
            return 0 ;
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, n = stations.length, stops = 0, maxDistance = tank;
        while(maxDistance < target){
            while(i < n && stations[i][0] <= maxDistance){
                queue.offer(stations[i++][1]);
            }
            
            if(queue.isEmpty())
                return -1;
            
            maxDistance += queue.poll();
            stops++;
        }
        
        return stops;
    }
}
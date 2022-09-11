class Solution {
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] candidates = new int[n][2];
        int MOD = 1000000007 ;
        long speedSum = 0, maxPerformance = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            candidates[i][0] = efficiency[i];
            candidates[i][1] = speed[i];
        }
        
        Arrays.sort(candidates, (a, b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0 ; i < n ; i++){
            q.offer(candidates[i][1]);
            speedSum += candidates[i][1];
            
            if(q.size() > k){
                speedSum -= q.poll();
            }
            
            maxPerformance = Math.max(maxPerformance, speedSum * candidates[i][0]);
        }
        maxPerformance = maxPerformance % MOD;
        return (int)(maxPerformance);
    }   
}



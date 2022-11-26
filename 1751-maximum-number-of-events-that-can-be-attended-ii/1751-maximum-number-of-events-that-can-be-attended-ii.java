class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) ->{
            if(a[0] ==  b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int max = 0 ;
       
            Integer[][] dp = new Integer[events.length + 1][k + 1];
            
        return solve(events, 0, k, -1, 0, dp);
        
        
    }
    
    public int solve(int[][] events, int index, int k, int pre, int endTime, Integer[][] dp){
        if(index >= events.length || k == 0)
            return 0 ;
        
        if(pre >= 0 && dp[pre][k] != null)
            return dp[pre][k];
        
        int pick = 0, notpick = 0 ;
        if(events[index][0] > endTime){
            pick = events[index][2] + solve(events, index + 1 , k - 1, index, events[index][1], dp);
        }
            
        notpick = solve(events, index + 1, k, pre, endTime, dp);
        int ans = Math.max(pick, notpick);
        if(pre >= 0){
            dp[pre][k] = ans;
        }
       
        return ans;
    }
}
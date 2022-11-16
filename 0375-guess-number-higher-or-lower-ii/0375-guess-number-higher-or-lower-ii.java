class Solution {
    public int getMoneyAmount(int n) {
        Integer[][] dp =new Integer[n + 1][n + 1];
        return solve(1, n, dp);
    }
    
    public int solve(int start, int end, Integer[][] dp){
        if(start >= end)
            return 0 ;
        
        if(dp[start][end] != null)
            return dp[start][end];
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            min = Math.min(min, i + Math.max(solve(start, i - 1, dp), solve(i + 1, end, dp)));
        }
        return dp[start][end] = min;
    }
}
class Solution {
    private int k ;
    private int n;
    private int target;
    
    private int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        this.target = target;
        Integer[][] dp = new Integer[n + 1][target + 1];
        return solve(1, 0, dp);
    
    }
    
    public int solve(int dice, int currentSum, Integer[][] dp){
        if(dice == n + 1){
            if(currentSum == target)
                return 1;
            else
                return 0 ;
        }
        if(currentSum > target)
            return 0 ;
        
        if(dp[dice][currentSum] != null)
            return dp[dice][currentSum];
        
        long ways = 0 ;
        for(int i = 1 ; i <= k ; i++){
            int way = solve(dice + 1, currentSum + i, dp) % MOD;
            ways = (ways + way) % MOD;
        }
        return dp[dice][currentSum] = (int)ways;
    }
}
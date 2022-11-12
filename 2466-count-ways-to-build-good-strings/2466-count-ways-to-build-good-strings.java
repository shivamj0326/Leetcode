class Solution {
    int MOD = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        
        long sum = 0 ;
        long[] dp  = new long[1000001];
        dp[0] = 1;
        
        for(int i = 1; i <= high; i++){
            if(i >= zero)
                dp[i] = (dp[i] + dp[i - zero])%MOD;
            if(i >= one)
                dp[i] = (dp[i] + dp[i - one])%MOD;
            if(i >= low)
                sum = (dp[i] + sum)%MOD;
        }
        
        
        return (int)sum;
    }

    
}
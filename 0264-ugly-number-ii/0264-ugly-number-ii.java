class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        int p = 0 , i = 0, j = 0, k = 0;
        int min = 0;
        while(p < n){
            min = Math.min(Math.min(dp[i] * 2, dp[j] * 3), dp[k] * 5);
            dp[++p] = min;
            
            if(min == dp[i] * 2)
                i++;
            if(min == dp[j] * 3)
                j++;
            if(min == dp[k] * 5)
                k++;
        }
        
        return dp[n - 1];
    }
}
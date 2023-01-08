class Solution {
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[n + 1][goal + 1];
        
        long[] fact = new long[n + 1];
        fact[0] = 1;
        
        for(int i = 1 ; i <=  n ; i++){
            fact[i] = (fact[i - 1] * i) % mod;
        }
        
        for(int i = k + 1; i <= n; i++){
            for(int j = i ; j <= goal; j++){
                
                if(i == j || i == k + 1)
                    dp[i][j] = fact[i];
                else
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - k))%mod;
                
            }
        }
        
        return (int)dp[n][goal];
    }
}
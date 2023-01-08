class Solution {
    int mod = 1000000007;
    long[] fact;
     long[][] dp ;
    int n;
    int goal;
    public int numMusicPlaylists(int n, int goal, int k) {
        this.n = n;
        this.goal = goal;
        //dp[i][j] denotes n unique songs in playlist of j songs
        dp = new long[n + 1][goal + 1];
        fact = new long[n + 1];
        fact[0] = 1;
        
        for(int i = 1 ; i <=  n ; i++){
            fact[i] = (fact[i - 1] * i) % mod;
        }
        
        
        
//         for(int i = k + 1; i <= n; i++){
//             for(int j = i ; j <= goal; j++){
                
//                 //if number of unique songs are equal to number of songs req in playlist we take one each song.. total ways will be n!
//                 if(i == j)
//                     dp[i][j] = fact[i];
//                 else
//                 //if n - 1 songs are there in j - 1 songs, we can take arbitrary nth song in n ways or we can take one of the songs from i such that not taken from k songs
//                     dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - k))%mod;
                
//             }
//         }
        
        return (int)solve(n, goal, k);
    }
    
    public long solve(int N, int L, int K){
        if(N == L || N == K + 1)
            return dp[N][L] = fact[N];
        
        if(dp[N][L] != 0)
            return dp[N][L];
        
        dp[N][L] = (solve(N - 1, L - 1, K) * N + solve(N, L - 1, K) * (N - K))%mod;
        
        return dp[N][L] % mod;
    }
}
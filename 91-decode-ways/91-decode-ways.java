class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        int[] dp = new int[n + 3];
        
        Arrays.fill(dp, 1);
        
        if(s.charAt(0) == '0')
            return 0 ;

        
        for(int i = n - 1 ; i >= 0 ; i--){
            
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
                
            }
            if(i + 1 < n && (s.charAt(i + 1) - '0' <= 6 && s.charAt(i) - '0' <= 2 || s.charAt(i) - '0' < 2))
                dp[i] = dp[i + 2] + dp[i + 1];
            else
               dp[i] = dp[i + 1];
        }
               
        return dp[0];
        
    }
}
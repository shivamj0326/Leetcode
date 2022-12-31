class Solution {
    Integer[][] dp ;
    int m ;
    int n;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        dp = new Integer[m + 1][n + 1];
        return solve(0, 0, s, t);
    }
    
    public int solve(int l, int r, String s, String t){
        if(l == m && r == n)
            return 1;
        
        if(l == m)
            return 0 ;
        if(r == n)
            return 1;
        
        if(dp[l][r] != null)
            return dp[l][r];
        
        int ans = 0 ;
        
        if(s.charAt(l) == t.charAt(r)){
            int pick = solve(l + 1, r + 1, s, t);
            int notpick = solve(l + 1, r, s, t);
            ans = pick + notpick;
        }
        else{
            ans = solve(l + 1, r, s, t);
        }
        
        return dp[l][r] = ans;
    }
}
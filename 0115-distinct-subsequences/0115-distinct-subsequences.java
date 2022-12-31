class Solution {
    Integer[][] dp ;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length() + 1][t.length() + 1];
        return solve(0, 0, s, t);
    }
    
    public int solve(int l, int r, String s, String t){
        if(l == s.length() && r == t.length())
            return 1;
        
        if(l >= s.length())
            return 0 ;
        if(r >= t.length())
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
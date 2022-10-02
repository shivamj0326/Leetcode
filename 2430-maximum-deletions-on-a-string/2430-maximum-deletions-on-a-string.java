class Solution {
    public int deleteString(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        
        return solve(s, 0, dp);
    }
    
    public int solve(String s, int start, Integer[] dp){
        int n = s.length();
        if(start == s.length())
            return 0 ;
        
        if(dp[start] != null)
            return dp[start];
        
        int max = 1;
           
        for(int i =  start ; i < start + (n - start)/2 ; i++){
            if(dp[i] == null){
                String front = s.substring(start, i + 1);
                String rear = s.substring(i + 1, i + 1 + (i + 1 - start));
                if(front.equals(rear)){
                    max = Math.max(max, 1 + solve(s, i + 1, dp));
                }
            }     
        }
        return dp[start] = max;
    }
}
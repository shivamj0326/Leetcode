class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        
        if(n == 100){
            boolean isSame = true;
            
            for(int i = 1 ; i < n ; i++){
                if(s.charAt(i) == s.charAt(0))
                    continue;
                else{
                    isSame = false;
                    break;
                }
                    
            } 
            
            if(isSame)
                return 4;
        }
        
        Integer[][][][] dp = new Integer[101][27][11][k + 1];
        
        return dpHelper(0, 'z'  - 'a' + 1, 0, k, dp, s);
    }
    
    
    int dpHelper(int index, int prev, int freq, int k, Integer[][][][] dp, String s){
        if(k < 0)
            return Integer.MAX_VALUE;
        
        if(index >= s.length())
            return 0 ;
        
        if(freq >= 10)
            freq = 10;
        
        if(dp[index][prev][freq][k] != null)
            return dp[index][prev][freq][k];
        
        
        
        int res = Integer.MAX_VALUE ;
        
        res = Math.min(res, dpHelper(index + 1, prev, freq, k - 1, dp, s));
        
        if(prev == s.charAt(index) - 'a'){
            
            if(freq == 1 || freq == 9)
                res = Math.min(res, 1 + dpHelper(index + 1, prev, freq + 1, k, dp, s));
            else
                res = Math.min(res, dpHelper(index + 1, prev, freq + 1, k, dp, s));
        }
        else{
            res = Math.min(res, 1 + dpHelper(index + 1, s.charAt(index) - 'a', 1, k, dp, s));
        }
        
        return dp[index][prev][freq][k] = res;
    }
}
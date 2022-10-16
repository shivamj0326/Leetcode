class Solution {
    public int minDifficulty(int[] nums, int d) {
        int n = nums.length;
        
        if(d > n)
            return -1;
        
        Integer[][] dp = new Integer[d + 1][n + 1];
        
        return solve(nums, d, 1, 0, dp);
            
    }
    
    public int solve(int[] nums, int total, int d, int index, Integer[][] dp){
        
        if(d == total + 1 && index == nums.length)
            return 0 ;
        if(d > total || index >= nums.length)
            return Integer.MAX_VALUE ;
        
        int mex = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        
        if(dp[d][index] != null)
            return dp[d][index];
        
        
        for(int i = index ; i < nums.length - (total - d); i++){
            mex = Math.max(mex, nums[i]);
            int sub = solve(nums, total, d + 1, i + 1, dp);
            if(sub != Integer.MAX_VALUE){
                res = Math.min(res, mex + sub);
            }
        }
        
        return dp[d][index] = res;
    }
}
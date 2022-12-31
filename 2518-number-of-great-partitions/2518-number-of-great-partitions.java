class Solution {
    int mod = 1000000007;
    public int countPartitions(int[] nums, int k) {
        
        long total = 0;
        int n = nums.length, ans = 1, sum = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        
        for(int i = 0 ; i < n ; i++){
            ans = (ans * 2) % mod;
            total += nums[i];
            
            for(int j = k - 1 ; j >= nums[i]; j--){
                dp[j] = (dp[j] + dp[j - nums[i]])% mod;
            }
        }
        //System.out.println(ans);
        
        if(total < 2 * k)
            return 0 ;
        
        for(int i = 0 ; i < k ; i++){
            sum = (sum + dp[i])%mod;
        }
        
        return ((ans - 2 * sum + mod) % mod);
    }
}
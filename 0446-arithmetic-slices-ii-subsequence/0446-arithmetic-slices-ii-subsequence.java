class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            dp[i] = new HashMap<Integer, Integer>();
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                long diff = (long)(nums[i]) - (long)nums[j];
                
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE)
                    continue;
                
                int c = dp[i].getOrDefault((int)diff, 0);
                
                int d = dp[j].getOrDefault((int)diff, 0);
                
                dp[i].put((int)diff, c + d + 1);
                
                ans += d;
                
            }
        }
        
        return ans;
    }
}
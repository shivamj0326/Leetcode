class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0 , n = nums.length;
        
        long[] prefix = new long[n + 1];
        
        for(int i = 1 ; i <= n ; i++){
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }
        
        for(int i = 1 ; i < n ; i++){
            if(prefix[i] >= prefix[n] - prefix[i])
                count++;
        }
        
        return count;
    }
}
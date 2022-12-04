class Solution {
    public int minimumAverageDifference(int[] nums) {
        long min = Long.MAX_VALUE;
        int n = nums.length, minIndex = -1;
        
        long[] prefix = new long[n + 1];
        
        for(int i = 1 ; i <= n ; i++){
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }
        
        for(int i = 1 ; i < n ; i++){
            long first = prefix[i]/i;
            long last = (prefix[n] - prefix[i])/(n - i);
            if(min > Math.abs(first - last)){
                minIndex = i - 1;
                min = Math.abs(first - last);
            }
        }
        if(min > (prefix[n]/n))
            return n - 1;
        
        return minIndex;
    }
}
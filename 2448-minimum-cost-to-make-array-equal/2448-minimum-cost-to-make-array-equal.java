class Solution {
    public long minCost(int[] nums, int[] cost) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int low = min, high = max;
        long res = get(nums, cost, low) ;
        
        while( low < high){
            int mid = low + (high - low)/2;
            
            long dmid = get(nums, cost, mid);
            long d1 = get(nums, cost, mid + 1);
            res = Math.min(dmid, d1);
            
          if(dmid < d1)
                high  = mid;
            else 
                low = mid + 1;
        }
        
        return res;
    }
    
    public long get(int[] nums, int[] cost, int pivot){
        long ans = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            ans += (long)Math.abs(pivot - nums[i]) * cost[i];
        }
        return ans;
    }
}
class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        
        
        if(k == 0)
            return nums[0];
        
        if(n == 1)
            return k % 2 == 0 ? nums[0] : -1;
        
        if(k == 1)
            return n > 1 ? nums[1] : -1;
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < Math.min(k - 1, n) ; i++){
            max = Math.max(max, nums[i]);
        }
        
        if(n > k)
            max = Math.max(max, nums[k]);
        
        return max;
    }
}
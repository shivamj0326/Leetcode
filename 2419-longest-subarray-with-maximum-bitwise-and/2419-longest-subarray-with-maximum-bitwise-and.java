class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, max = 0, maxe = 0, k = 0;
        
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, nums[i]);
        }
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == max)
                k++;
            else
            {
                
                maxe = Math.max(maxe, k);
                k = 0;
            }
        }
        return Math.max(maxe, k);
    }
}
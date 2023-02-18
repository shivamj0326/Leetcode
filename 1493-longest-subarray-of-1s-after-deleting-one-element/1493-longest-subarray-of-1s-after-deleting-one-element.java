class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0 , n = nums.length, max = 0, zeroes = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0)
                zeroes++;
            
            if(zeroes > 1 && nums[left++] == 0)
                zeroes--;
            
            max = Math.max(max, i - left);
        }
        
        return max;
    }
}
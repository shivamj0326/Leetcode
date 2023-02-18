class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, max = 0 ;
        int left = 0, zeroes = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0)
                zeroes++;
            
            if(zeroes > k && nums[left++] == 0)
                zeroes--;
            
            max = Math.max(max, i - left + 1);
        }
        return max; 
    }
}
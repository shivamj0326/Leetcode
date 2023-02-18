class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, max = 0 ;
        int left = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0)
                k--;
            
            if(k < 0 && nums[left++] == 0)
                k++;
            max = Math.max(max, i - left + 1);
        }
        return max; 
    }
}
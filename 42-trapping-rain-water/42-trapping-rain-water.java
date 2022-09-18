class Solution {
    public int trap(int[] nums) {
        int n = nums.length, res = 0 ;
        
        int left = 0 , right = n - 1;
        
        for(int i = 1 ; i < n ; i++){
            if(nums[i] >= nums[left]){
                for(int j = left + 1 ; j < i; j++){
                    res += nums[left] - nums[j];
                }
                left = i ;
            }
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] > nums[right]){
                for(int j = right - 1 ; j > i ; j--){
                    res += nums[right] - nums[j];
                }
                right = i ;
            }
        }
        
        return res;
        
        
        
    }
}
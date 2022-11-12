class Solution {
    public int findMin(int[] nums) {
        int low = 0, hi = nums.length - 1;
        
        while(low < hi){
            int mid = low + (hi - low)/2 ;
            
            if(nums[mid] > nums[hi]){
                low = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        
        return nums[low];
    }
}
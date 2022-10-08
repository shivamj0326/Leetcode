class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, minSum = 0, n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            int low = i + 1;
            int high = n - 1;
            while(low < high){
                int mid = nums[low] + nums[high] + nums[i];
                if(min > Math.abs(target - mid)){
                    minSum = mid;
                    min = Math.abs(target - mid);
                }
                if(mid < target){
                    low++;
                }
                else if(mid > target)
                    high--;
                else
                    return mid;
            }
        }
        
        return minSum;
    }
}
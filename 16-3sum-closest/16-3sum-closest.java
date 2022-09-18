class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, min = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < n - 2 ; i++){
            
            int left = i + 1, right = n - 1, sum = 0;
            while(left < right){
                
                sum = nums[left] + nums[right] + nums[i];
                if(min > Math.abs(target - sum)){
                    res = sum;
                    min = Math.abs(target - sum);
                }
                if(sum > target)
                    right--;
                else if(sum < target)
                    left++;
                else
                    return sum;
            }   
        }
        return res;
    }
}
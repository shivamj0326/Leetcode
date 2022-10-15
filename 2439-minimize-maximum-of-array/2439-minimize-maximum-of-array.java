class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = nums[0] ;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if(nums[i] > max)
                max =(long) Math.max(max, (sum + i)/(i + 1));
        } 
        return (int) max;
    }
}
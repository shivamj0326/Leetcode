class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        int count = 0, max = Integer.MIN_VALUE;
        
        for(int i : nums){
            count = 0 ;
            while(!vis[i]){
                count++;
                vis[i] = true;
                i = nums[i];
            }
            max = Math.max(max, count);
        }
       
        return max;
        
    }
}
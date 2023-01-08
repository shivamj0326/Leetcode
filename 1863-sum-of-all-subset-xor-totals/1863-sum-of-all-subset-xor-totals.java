class Solution {
    
    public int subsetXORSum(int[] nums) { 
        int ans = 0 ;
        
        for(int i : nums)
            ans |= i;
        
        return (int)(ans * (Math.pow(2, nums.length - 1)));
    }
    
    public int dfs(int[] nums, int index, int current){
        if(index == nums.length){
            return current;
        }
       
        return dfs(nums, index + 1, current ^ nums[index]) + dfs(nums, index + 1, current);

    }
}
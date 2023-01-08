class Solution {
    List<Integer> res = new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        
        dfs(nums, 0, 0);
        int sum = 0;
        for(int i : res)
            sum += i;
        
        return sum;
    }
    
    public void dfs(int[] nums, int index, int current){
        if(index == nums.length){
            res.add(current);
            return;
        }
       
        dfs(nums, index + 1, current ^ nums[index]);
        
        dfs(nums, index + 1, current);

    }
}
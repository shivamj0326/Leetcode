class Solution {
    public int destroyTargets(int[] nums, int space) {
        int index = nums[0];
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            
            map.put(nums[i] % space, map.getOrDefault(nums[i] % space, 0) + 1);
        }
        
        
        int max = 0, ans = 0;
        
        for(int i : nums){
            int t = i % space;
            
            if(map.get(t) > max){
                max = map.get(t);
                ans = i;
            }
        }
        return ans;
        
        
    }
}
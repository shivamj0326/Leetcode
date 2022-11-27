class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int ans = 0, sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        boolean found = false;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] < k){
                sum--;
            }
            else if(nums[i] > k){
                sum++;
            }
            else{
                found = true;
            }
            
            if(found){
                ans += map.getOrDefault(sum, 0) + map.getOrDefault(sum - 1, 0);
            }
            else{
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        return ans;
    }
}
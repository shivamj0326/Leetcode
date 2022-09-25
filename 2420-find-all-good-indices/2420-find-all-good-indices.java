class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);
        for(int i = 1 ; i < n ; i++){
            if(nums[i] <= nums[i - 1])
                prefix[i]  += prefix[i - 1];
            
            
        }
        
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] <= nums[i + 1])
                suffix[i] += suffix[i + 1];
        }
        
        for(int i = 1 ; i < n - k ; i++){
            if(prefix[i - 1] >= k && suffix[i + 1] >= k)
                ans.add(i);
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            int target = - nums[i];
            int left = i + 1;
            int right = n - 1;
            int sum = 0 ;
            while(left < right){
                sum = nums[left] + nums[right];
            
                if(sum > target)
                    right--;
                else if(sum < target)
                    left++;
                else{
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    while(left + 1 < n && nums[left + 1] == nums[left])
                        left++;
                    left++;
                    right--;
                }
            }   
            while(i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }
        return triplets;
    }
}
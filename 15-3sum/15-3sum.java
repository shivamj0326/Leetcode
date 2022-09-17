class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        //sorted array, hence if nums[i] positive, result cannot be zero
        for(int i = 0 ; i < n && nums[i] <= 0; i++){
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
                    //avoid duplicate in left term
                    while(left + 1 < n && nums[left + 1] == nums[left])
                        left++;
                    left++;
                    right--;
                }
            }   
            //Avoid duplicate in ith term
            while(i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }
        return triplets;
    }
}
/*
 Time Complexity : O(nlogn)
 Space Complexity : O(1) if output excluded 
*/
 
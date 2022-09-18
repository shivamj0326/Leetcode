class Solution {
    int MOD = 1000000007;
    public int threeSumMulti(int[] nums, int target) {
        int n = nums.length, left = 0 , right = n - 1, ans = 0, sum  = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++){
            int tar = target - nums[i];
            left = i + 1;
            right = n - 1;
            
            while(left < right){
                sum = nums[left] + nums[right];
                if(sum > tar)
                    right--;
                else if(sum < tar)
                    left++;
                else if(nums[left] != nums[right]){
                    int j = 1, k = 1;
                    while(left + 1 < right && nums[left + 1] == nums[left]){
                        j++;
                        left++;
                    }
                    while(right - 1 > left  && nums[right - 1] == nums[right]){
                        right--;
                        k++;
                    }
                    ans += j * k;
                    ans = ans % MOD;
                    left++;
                    right--;
                }
                else{
                    int len = right - left + 1;
                    
                    ans += (len * (len - 1)) / 2 ;
                    ans = ans % MOD;
                    break;
                }
            }
        }
        return ans;
    }
}
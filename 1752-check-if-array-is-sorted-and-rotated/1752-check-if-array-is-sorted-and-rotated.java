class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            for(int j = i ; j < i + n ; j++){
                if(nums[j % n] <= nums[(j + 1) % n])
                    count++;
            }
            if(count >= n - 1)
                return true;
        }
        return false;
    }
}
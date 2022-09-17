class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0 , n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            int j = i + 1;
            while(j < n && nums[j] != diff + nums[i])
                j++;
            int k = j + 1;
            while(k < n && nums[k] != diff + nums[j])
                k++;
            if(k < n)
                count++;    
        }
        return count;
    }
}
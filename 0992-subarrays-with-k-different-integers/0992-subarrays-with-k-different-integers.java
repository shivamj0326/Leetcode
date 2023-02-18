class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       int countK = subArrayK(nums, k);
       int countK1 = subArrayK(nums, k - 1);
        return countK - countK1;
    }
    public int subArrayK(int[] nums , int k){
        if(nums.length <= k){
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0 , currentWindow = 0, n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);  
            while(map.size() == k + 1){
                //take the rightmost index of first character 
                map.put(nums[currentWindow], map.get(nums[currentWindow]) - 1);
                if(map.get(nums[currentWindow]) == 0)
                    map.remove(nums[currentWindow]);
                currentWindow += 1;
            }
             count += i + 1 - currentWindow;     
        }
        return count;
    }
}
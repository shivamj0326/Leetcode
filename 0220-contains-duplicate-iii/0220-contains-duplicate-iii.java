class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            Integer s = set.ceiling(nums[i]);
            Integer g = set.floor(nums[i]);
            if(s != null && s <= nums[i] + t)
                return true;
            if(g != null && nums[i] <= (long)g + t)
                return true;
            set.add(nums[i]);
            if(i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
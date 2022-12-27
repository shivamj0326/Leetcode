class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, check(nums, i));
        }
        
        return max <= 1 ? -1 : max;
    }
    
    public int check(int[] nums, int index){
        int prev = nums[index], d = 1;
        
        int l = index + 1, r = nums.length - 1;
        
        while(l <= r){
            int search = prev * prev;
            int mid = l + (r - l)/2;
            if(nums[mid] > search){
                r = mid - 1;
            }
            else if(nums[mid] < search){
                l = mid + 1;
            }
            else{
                d++;
                prev = nums[mid];
               // System.out.println(prev);
                l = mid + 1;
                r = nums.length - 1;
            }
        }
        
        return d ;
    }
}
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] a = new int[n];
        int[] b = new int[n];
        
        Arrays.fill(a, 1);
        Arrays.fill(b, 1);
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j] && (a[i] < 1 + a[j]))
                    a[i] = 1 + a[j];
            }
        }
        
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = n - 1 ; j > i ; j--){
                if(nums[i] > nums[j] && (b[i] < 1 + b[j]))
                    b[i] = 1 + b[j];
            }
        }
        int max = 0;
        for(int i = 0 ; i < n ; i++){
      
            if(a[i] > 1 && b[i] > 1)
                max = Math.max(max, a[i] + b[i] - 1);
        }
        
        return n - max;
    }
}
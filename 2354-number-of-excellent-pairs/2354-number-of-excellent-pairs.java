class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long[] count = new long[32];
        long ans = 0 ;
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int num : set){
            count[Integer.bitCount(num)]++;
        }
        
        for(int i = 1 ; i <= 30 ; i++){
            for(int j = 1 ; j <= 30 ; j++){
                if(i + j >= k){
                    ans += count[i] * count[j];
                }
            }
        }
        
        return ans;
        
    }
}
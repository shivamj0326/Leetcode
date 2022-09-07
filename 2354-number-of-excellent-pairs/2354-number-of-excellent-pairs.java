class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long ans = 0 ;
        
        for(int num : nums){
            set.add(num);
        }
        
        Integer[] arr = set.toArray(new Integer[set.size()]);
        
        Arrays.sort(arr, (a, b) -> {
            return Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b);
        });
        
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.bitCount(arr[i]);
        }
            
        for(int i = 0 ; i < arr.length ; i++){
            
            if(arr[i] >= k)
                ans += 2*i + 1;
            else{
                 int index = search(arr, i, k - arr[i]);
                if(index != -1)
                    ans += (i - index)*2 + 1;
            }        
        }
        return ans;
    }
    
    public int search(Integer[] arr,int index, int target){
        int low = 0 , high = index, ans = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}
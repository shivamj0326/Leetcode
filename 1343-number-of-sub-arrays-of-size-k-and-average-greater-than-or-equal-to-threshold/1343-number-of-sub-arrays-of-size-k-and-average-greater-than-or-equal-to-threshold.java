class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0 , value = threshold * k, count = 0, n = arr.length, end = 0, start = 0;
         
        while(end < n){
            sum += arr[end];
            end++;
            if(end - start == k){
                if(sum >= value)
                    count++;
                sum -= arr[start];
                start++;
            }
        }
        
        return count;
    }
}
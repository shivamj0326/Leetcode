class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        long sum = 0 ;
        
        int n = arr.length;
        
        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
        }
        int count = 0;
        
        int avg = (int)(sum/k);
        if(avg >= threshold)
            count++;
        
        for(int i = k ; i < n ; i++){
            sum -= arr[i - k];
            sum += arr[i];
            
            avg = (int)(sum/k);
            if(avg >= threshold)
                count++;
        }
        
        return count;
    }
}
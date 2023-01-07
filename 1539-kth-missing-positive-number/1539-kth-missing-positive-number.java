class Solution {
    public int findKthPositive(int[] arr, int k) {
       
        for(int i = 1; i <= 2000 ; i++){
            if(!search(arr, i))
                k--;
            
            if(k == 0)
                return i;
        }
        
        return -1;
    }
    
    public boolean search(int[] arr, int x){
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(arr[mid] == x)
                return true;
            else if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }
}
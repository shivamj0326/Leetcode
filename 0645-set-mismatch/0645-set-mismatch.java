class Solution {
    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        
        int[] count = new int[n + 1];
        
        for(int i = 0; i < n ; i++){
            count[arr[i]]++;
        }
        
        int miss = 0, duplicate = 0;
        
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 0)
                miss = i;
            if(count[i] == 2)
                duplicate = i;
        }
        
        return new int[]{duplicate, miss};
    }
}
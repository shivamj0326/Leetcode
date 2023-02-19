class Solution {
    public int minOperations(int n) {
        int x = 1;
        if(n == 0)
            return 0 ;
        
        while(x < n){
            x = x * 2;
        }

        int diff = Math.min(n - x/2 , x - n);
        return 1 + minOperations(diff);

    
      
    }
}
class Solution {
    public boolean isUgly(int n) {
        while(n > 1){
            int temp = n ;
            while(n % 5 == 0)
                n = n/5;
            while(n % 3 == 0)
                n = n/3;
            while(n % 2 == 0)
                n = n/2;
            if(n == temp)
                break;
            
        }
        return n == 1;
        
    }
}
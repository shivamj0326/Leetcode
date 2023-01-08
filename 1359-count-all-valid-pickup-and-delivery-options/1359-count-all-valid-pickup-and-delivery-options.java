class Solution {
    int MOD = 1000000007;
    public int countOrders(int n) {
       long res = 1;
        
        for(int i = 1 ; i <= 2 * n ; i+=2){
            
            res = (res * i * (i + 1))/2;
            res = res % MOD;
        }
        
        return (int)res;
           
    
    }
}
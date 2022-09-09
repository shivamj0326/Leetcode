class Solution {
    int MOD = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos - startPos);
        if(k - diff == 0)
            return 1 ;
        
        if(diff > k || (k - diff) % 2 != 0)
            return 0;
        
        long[] fact = new long[k + 1];
        Arrays.fill(fact, 1);
        for(int i =  1; i <= k ; i++){
            fact[i] = (fact[i - 1] * i) % MOD ;     
        }
        
       
        int plus = (diff + k)/2;
        int minus = (k - diff)/2 ;
        
      
        long ans = fact[k] * inverse(fact[plus]) % MOD ;
        ans = ans * inverse(fact[minus]) % MOD;
        return (int)(ans % MOD);     
        
    }
    
    long inverse(long x){
        return power(x, MOD - 2, MOD);
    }
    long power(long x, int y, int p){
        long res =  1;
        x = x % p;

        while(y > 0) {
            if((y & 1) == 1) 
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
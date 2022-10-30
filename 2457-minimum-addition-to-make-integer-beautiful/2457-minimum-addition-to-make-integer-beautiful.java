class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        if(n <= target)
            return 0 ;
        
        return getSum(n, target);
        
    }
    
    public long getSum(long n, int target){
        long temp = n;
        long sum = gsum(n);
        long diff = 0 ;
        long multiplier = 1;
        StringBuilder sb = new StringBuilder();
        while(sum > target){
            diff =  diff + ((10 - temp % 10) * multiplier);
            multiplier = multiplier * 10;
            
            temp = (temp/10) + 1;
            sum = gsum(temp);
            
        }
        return diff;   
    }
    
    public long gsum(long n){
        long sum = 0;
        while(n > 0){
            sum += n % 10;
            n = n/10;
        }
        return sum;
    }
}
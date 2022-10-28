class Solution {
    public int divide(int a, int b) {
        if(a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        
        int res = 0 , dividend = a, divisor = b;
        
        a = Math.abs(a);
        b = Math.abs(b);
        
        while(a - b >= 0){
            int temp = b, count = 1;
            
            while(a - (temp << 1) >= 0){
                temp = temp << 1;
                count = count << 1;
            }
            a -= temp;
            res += count;
            
        }
        
        return dividend > 0 == divisor > 0 ? res : -res;
    }
}

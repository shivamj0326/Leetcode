class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        int n = s.length();
        
        if(n == 0)
            return 0 ;
        
        boolean neg = false;
        int i = 0;
        
        if(s.charAt(0) == '-'){
            neg = true;
            i++;
        }
        else if(s.charAt(0) == '+')
            i++;     
        
        int digit = 0 , sum = 0 ;
        while(i < n && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
            digit = s.charAt(i) - '0';
            
            if(sum > (Integer.MAX_VALUE - digit)/10)
                return Integer.MAX_VALUE;
            if(sum < (Integer.MIN_VALUE + digit)/10)
                return Integer.MIN_VALUE;
            if(neg)
                sum = sum * 10 - digit;
            else
                sum = sum * 10 + digit;
            i++;
        }
        
        return sum;
            
    }
}
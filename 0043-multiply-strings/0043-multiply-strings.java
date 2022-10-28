class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        
        int[] multi = new int[m + n];
        
        int l = 0 ;
        for(int j = n - 1; j >= 0 ; j--){
            int p = num1.charAt(j) - '0';
            int sum = 0, carry = 0, product = 0;
            int i = l;
            for(int k = m - 1; k >= 0; k--){
                int q = num2.charAt(k) - '0';
                product = p * q + multi[i] + carry;
                sum = product % 10 ;
                
                multi[i] = sum;
                carry = product / 10 ;
                i++;
            }
            if(carry > 0)
                multi[i] = carry;
            l++;
        }
        
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for(int i = m + n - 1 ; i >= 0; i--){
            if(multi[i] == 0 && !flag)
                continue;
            if(multi[i] != 0)
                flag = true;
            sb.append("" + multi[i]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

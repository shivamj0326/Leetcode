class Solution {
    public String smallestNumber(String pattern) {
        
        
        int n = pattern.length();
        int min = 1;
        
        int beenSet = -1 ;
        
        // we need resultant string of length n + 1
        StringBuilder sb = new StringBuilder(pattern + " ");
        
        for(int i = 0 ; i < n ; i++){
            
            char ch = pattern.charAt(i);
            
            //encounter I set min possible at this index
            if(ch == 'I'){
                //ascii of '0' is 48
                sb.setCharAt(i, (char)(min++ + 48));
                // set min possible at All 'D' to the left of 'I' and not been set so far
                for(int j = i - 1 ; j > beenSet ; j--){
                    sb.setCharAt(j, (char)(min++ + 48));
                }
                beenSet = i ;
            }  
        }
        //for characters not been set
        for(int i = n ; i > beenSet ; i--){
            sb.setCharAt(i, (char)(min++ + 48));
        }
        return sb.toString();
        
        
    }
}
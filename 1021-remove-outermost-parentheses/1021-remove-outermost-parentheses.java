class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int counter = 0 ;
        StringBuilder sb = new StringBuilder();
        boolean one = true;
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '(')
                counter++;
            else
                counter--;
            
            if((!one && counter == 0) || (one && counter == 1)){
                one = !one;
                continue;
            }
               
            sb.append(ch);
                
          
        }
       
        return sb.toString();
    }
}
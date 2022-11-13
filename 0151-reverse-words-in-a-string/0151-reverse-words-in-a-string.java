class Solution {
    public String reverseWords(String s) {
        int l = 0;
        s = s.trim();
        int n = s.length();
        
        Stack<String> stack = new Stack<>();
        int i = 0 ;
        while(i < n){
            if(s.charAt(i) != ' '){
                i++;
                continue;
            }
            stack.push(s.substring(l, i));
            while(s.charAt(i) == ' '){
                l = i ;
                i++;
                l++;
            }
            i++;
            
        }
        if(l != n)
        stack.push(s.substring(l, n));
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
            
        }
        
        return sb.toString().trim();
    }
}
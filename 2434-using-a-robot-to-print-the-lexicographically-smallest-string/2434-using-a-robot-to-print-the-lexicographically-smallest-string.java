class Solution {
    public String robotWithString(String s) {
        int[] count = new int[26];
        
        StringBuilder sb = new StringBuilder();
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()){
            count[ch - 'a']++; 
        }
        
        int pointer = 0, n = s.length() ;
        
        
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            stack.push(ch);
            count[ch - 'a']-- ;
            
            while(pointer < 26 && count[pointer] == 0)
                pointer++;
            
            
            while(!stack.isEmpty() && stack.peek() <= (char)(pointer + 'a')){
                sb.append(stack.poll());
            }
        }
        
        return sb.toString();
    }
}


class Solution {
    class Pair{
        Character first;
        int second;
        
        Pair(char first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int longestValidParentheses(String s) {
        Deque<Pair> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(new Pair('(', i));
                
            }
            else{
                if(!stack.isEmpty() && stack.peek().first == '(')
                    stack.pop();
                else
                    stack.push(new Pair(')', i));
            }
        }
        System.out.println(stack.size());
        
        int n = s.length();
        while(!stack.isEmpty()){
            max = Math.max(max, n - stack.peek().second - 1);
            
            n = stack.pop().second;

        }
        max = Math.max(max, n);
        
        return max;
    }
}
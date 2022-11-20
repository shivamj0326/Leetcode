class Solution {
    public int calculate(String s) {
        int n = s.length();
        
        int sum = 0, sign = 1;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            int x = s.charAt(i) - '0';
            if(x >= 0 && x <= 9){
                int num = 0 ;
                while(i < n && s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0){
                    num = num * 10 + s.charAt(i) - '0' ;
                    i++;
                }
                i--;
                sum += num * sign;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                sum = stack.pop() * sum ;
                sum += stack.pop();
            }
        }
        
        return sum;
    }
}
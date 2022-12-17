class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("*", "+", "-", "/");
        
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        
        
        for(String s : tokens){
            if(operators.contains(s)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                    
                stack.push(evaluate(num2, num1, s));
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
    
    public int evaluate(int num1, int num2, String op){
        if(op.equals("+")){
            return num1 + num2;
        }
        else if(op.equals("-")){
            return num1 - num2;
        }
        else if(op.equals("*")){
            
            return num1 * num2;
        }
        else{
            return num1/num2;
        }
    }
}
class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int len = 0;
        
        int left = 0 , right = n - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                break;
            else{
                char ch = s.charAt(left);
                while(left <= right && s.charAt(left) == ch){
                    left++;
                    len++;
                }
                while(right > left && s.charAt(right) == ch){
                    right--;
                    len++;
                }
                    
            }
        }
        return n - len;
    }
    
}
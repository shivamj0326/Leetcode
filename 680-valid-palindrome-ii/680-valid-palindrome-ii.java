class Solution {
    boolean flag = false;
    String s;
    public boolean validPalindrome(String s) {
        int n = s.length();
        this.s = s;
        return helper(0, n -1);
    }
    
    public boolean helper(int start, int end){
        if(start > end)
            return true;
        if(s.charAt(start) == s.charAt(end))
            return helper(start + 1, end - 1);
        if(!flag){
            flag = true;
            return helper(start + 1, end) || helper(start, end - 1);
        }
        else
            return false;
    }
}
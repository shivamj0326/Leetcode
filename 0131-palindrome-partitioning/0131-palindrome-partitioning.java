class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<String>(), s);
        return res;
    }
    
    void dfs(int index, List<List<String>> res, List<String> current, String s){
        if(index >= s.length()){
            res.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = index ; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                current.add(s.substring(index, i + 1));
                dfs(i + 1, res, current, s);
                current.remove(current.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }
        
        return true;
    }
}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dfs(0, res, new ArrayList<String>(), s, dp);
        return res;
    }
    
    void dfs(int index, List<List<String>> res, List<String> current, String s, boolean[][] dp){
        if(index >= s.length()){
            res.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = index ; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i) && (i - index <= 2 || dp[index + 1][i - 1] == true)){
                dp[index][i] = true;
                current.add(s.substring(index, i + 1));
                dfs(i + 1, res, current, s, dp);
                current.remove(current.size() - 1);
            }
        }
    }

}
class Solution {
    public int minDeletionSize(String[] strs) {
        Set<Integer> res = new HashSet<>();
        
        int m = strs.length, n = strs[0].length();
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(strs[i].charAt(j) < strs[i - 1].charAt(j))
                    res.add(j);
            }
        }
        
        return res.size();
    }
}
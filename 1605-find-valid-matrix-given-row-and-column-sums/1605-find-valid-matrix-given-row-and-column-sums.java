class Solution {
    public int[][] restoreMatrix(int[] row, int[] col) {
        
        int m = row.length, n = col.length;
        
        int[][] res = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                res[i][j] = Math.min(row[i], col[j]);
                row[i] -= res[i][j];
                col[j] -= res[i][j];
            }
        }
        
        return res;
        
    }
}
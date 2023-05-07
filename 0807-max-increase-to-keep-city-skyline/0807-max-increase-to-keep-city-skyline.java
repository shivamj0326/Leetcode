class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxr = 0, maxc = 0, sum = 0, currentsum = 0 ;
        
        Map<Integer, Integer> rowmap = new HashMap<>();
        Map<Integer, Integer> colmap = new HashMap<>();
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                maxr = Math.max(maxr, grid[i][j]);
                maxc = Math.max(maxc, grid[j][i]);
            }
            rowmap.put(i, maxr);
            colmap.put(i, maxc);
            
            
            maxr = 0;
            maxc = 0;
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum += Math.min(rowmap.get(i), colmap.get(j)) - grid[i][j];
            }
        }
        
        return sum;
    }
}
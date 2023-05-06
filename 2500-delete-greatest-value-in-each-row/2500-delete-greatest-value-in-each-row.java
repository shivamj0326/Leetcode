class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0 , sum  = 0;
        for(int i = 0 ; i < m ; i++){
            Arrays.sort(grid[i]);
        }
        
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < m ; i++){
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }
        
        return sum;
    }
}
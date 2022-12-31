class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, zero = 0, sx = 0, sy = 0;
        
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0)
                    zero++;
                if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        return dfs(sx, sy, grid, zero);
    }
    
    public int dfs(int x, int y, int[][] grid, int zero){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0 ;
        
        if(grid[x][y] == 2){
            return zero == -1 ? 1 : 0;
        }
       
        grid[x][y] = -1;
        zero--;
        
        int total = dfs(x + 1, y, grid, zero) 
                    + dfs(x, y + 1, grid, zero) 
                    + dfs(x - 1, y, grid, zero) 
                    + dfs(x, y - 1, grid, zero);
        grid[x][y] = 0 ;
        return total;
    }
}
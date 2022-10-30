class Solution {
    
    class Pair{
        int row;
        int col;
        int obs;
        int dist;
        
        Pair(int row, int col, int dist, int obs){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.obs = obs;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        
        int dir[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        
        
        boolean[][][] visited = new boolean[m][n][k + 1];
        
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            Pair current = q.poll();
            
            if(current.row == m - 1 && current.col == n - 1)
                return current.dist;
            
            for(int[] d : dir){
                int row = current.row + d[0];
                int col = current.col + d[1];
                
                if(row < 0 || row >= m || col < 0 || col >= n)
                    continue;
                
                if(current.obs + grid[row][col] > k)
                    continue;
                
                if(!visited[row][col][current.obs + grid[row][col]]){
                    visited[row][col][current.obs + grid[row][col]] = true;
                    q.offer(new Pair(row, col, current.dist + 1, current.obs + grid[row][col]));
                }
            }
        }
        
        return -1;     
    }
}
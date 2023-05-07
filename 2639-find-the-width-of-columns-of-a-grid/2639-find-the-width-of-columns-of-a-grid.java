class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        int max = 0 ;
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < m ; i++){
                max = Math.max(max, len(grid[i][j]));
            }
            res[j] = max;
            max = 0 ;
        }
        
        return res;
    }
    
    public int len(int x){
        
        int count = 0 ;
        if(x < 0){
            x = -x;
            count++;
        }
        if(x == 0)
            return 1;
        
        while(x > 0){
             x = x/10;
            count++;
        }
        
        return count;
    }
}
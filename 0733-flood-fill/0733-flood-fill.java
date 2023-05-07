class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int color = image[sr][sc];
        
        if(color == newcolor)
            return image;
        
        dfs(image, sr, sc, color, newcolor);
        
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int color, int newcolor){
        
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != color)
            return;
        
        
        image[r][c] = newcolor;
        
        dfs(image, r + 1, c, color, newcolor);
        dfs(image, r - 1, c, color, newcolor);
        dfs(image, r , c - 1, color, newcolor);
        dfs(image, r, c + 1, color, newcolor);
    }
}
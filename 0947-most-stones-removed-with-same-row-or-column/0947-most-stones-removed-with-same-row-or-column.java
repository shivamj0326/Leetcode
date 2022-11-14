class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length, count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(visited, stones, i);
                count++;
            }
        }
        
        return n - count;
        
    }
    
    public void dfs(boolean[] visited, int[][] stones, int index){
        visited[index] = true;
        
        for(int i = 0 ; i < stones.length; i++){
            if(!visited[i]){
                if(stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1]){
                    dfs(visited, stones, i);
                }
            }
        }
    }
}
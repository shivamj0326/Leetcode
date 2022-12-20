class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for(int i = 0 ; i < n ; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int index, boolean[] visited){
        visited[index] = true;
        
        for(int x : rooms.get(index)){
            if(!visited[x])
                dfs(rooms, x, visited);
        } 
      
    }
}
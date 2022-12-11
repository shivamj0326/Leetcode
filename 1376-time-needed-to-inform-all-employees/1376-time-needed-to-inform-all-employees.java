class Solution {
    int max = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < manager.length; i++){
            if(i == headID)
                continue;
            
            graph.get(manager[i]).add(i);
        }
        
        dfs(headID, -1, graph, 0, informTime);
        return max;
    }
    
    public void dfs(int src, int par, List<List<Integer>> graph, int sum, int[] time){
        max = Math.max(max, sum);
        for(int i : graph.get(src)){
            dfs(i, src, graph, sum + time[src], time);
        }
        
        
    }
}
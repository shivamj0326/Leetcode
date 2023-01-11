class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
    
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return  dfs(graph, hasApple, 0, -1);
        
    }
    
    public int dfs(List<List<Integer>> graph, List<Boolean> hasApple, int src, int par){
        int total = 0 ;
        boolean res = hasApple.get(src);
        for(int i : graph.get(src)){
            if(i == par)
                continue;
            int child = dfs(graph, hasApple, i, src);
            
            if(child > 0 || hasApple.get(i))
                total += 2 + child;
            
        }
        
        return total;
    }
}
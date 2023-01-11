class Solution {
    int res = 0 ;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs1(graph, hasApple, 0, -1);
     
        dfs2(graph, hasApple, 0, -1);
        return 2 * res;
        
        
    }
    
    public boolean dfs1(List<List<Integer>> graph, List<Boolean> hasApple, int src, int par){
        boolean res = hasApple.get(src);
        for(int i : graph.get(src)){
            if(i == par)
                continue;
            res |= dfs1(graph, hasApple, i, src);
            
        }
        
        hasApple.set(src, res);
        
        return res;
    }
    
    public void dfs2(List<List<Integer>> graph, List<Boolean> hasApple, int src, int par){
        for(int i : graph.get(src)){
            if(i == par)
                continue;
            
            if(hasApple.get(i)){
                res++;
                dfs2(graph, hasApple, i, src);
            }
        }
    }
}
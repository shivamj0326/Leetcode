class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length ; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph[i].length ; j++){
                adj.get(i).add(graph[i][j]);
            }       
        }
        List<Integer> subans = new ArrayList<Integer>();
        subans.add(0);
        dfs(adj, 0, n - 1, subans);
        return ans;
    }
    public void dfs(List<List<Integer>> adj, int source, int des, List<Integer> subans ){
        if(source == des){
            ans.add(new ArrayList<>(subans));
            return;
        }
        for(int i : adj.get(source)){
                subans.add(i);
                dfs(adj, i, des, subans);
                subans.remove(subans.size() - 1);
            }
        
    }
}
class Solution {
    public int[][] buildMatrix(int k, int[][] row, int[][] col) {
        int[][] ans = new int[k][k];
        
        List<List<Integer>> rowGraph = buildGraph(row, k);
        List<List<Integer>> colGraph = buildGraph(col, k);
        
        List<Integer> rows = sort(rowGraph, k);
        List<Integer> cols = sort(colGraph, k);
        
        if(rows.size() != k || cols.size() != k)
            return new int[][]{};
        
        for(int i = 1 ; i <= k ; i++){
            ans[rows.indexOf(i)][cols.indexOf(i)] = i ;
        }
        
        return ans;
    }
    
    public List<List<Integer>> buildGraph(int[][] row, int k){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= k ; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] r : row){
            graph.get(r[0]).add(r[1]);
        }
        return graph;
    }
    
    public List<Integer> sort(List<List<Integer>> graph, int k){
        List<Integer> sorted = new ArrayList<>();
        
        int[] indegree = new int[k + 1];
        boolean[] visited = new boolean[k + 1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < graph.size(); i++){
            for(int nei : graph.get(i)){
                indegree[nei]++;
            }
        }
        
        for(int i = 1 ; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                sorted.add(i);
                visited[i] = true;
            }
        }
        
        while(!queue.isEmpty()){
            
            int x = queue.poll();
            
            for(int nei : graph.get(x)){
                indegree[nei]--;
                if(indegree[nei] == 0 && !visited[nei]){
                    queue.offer(nei);
                    sorted.add(nei);
                    visited[nei] = true;
                }
            }
        }
        return sorted;
    }
    
   
}
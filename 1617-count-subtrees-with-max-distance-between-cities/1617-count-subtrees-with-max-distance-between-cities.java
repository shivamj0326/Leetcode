class Solution {
    int max = 0;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        int[] ans = new int[n - 1];
        
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        
        for(int i = 1 ; i < (1 << n) ; i++){
            Set<Integer> subtree = new HashSet<>();
            
            for(int j = 0 ; j < n ; j++){
                if((i & (1 << j)) != 0){
                    subtree.add(j + 1);
                }
            }
            
            int e = 0 ;
            
            for(int[] edge : edges){
                if(subtree.contains(edge[0]) && subtree.contains(edge[1]))
                    e++;
            }
            
            if(e == 0 || subtree.size() != e + 1)
                continue;
            
            Set<Integer> visited = new HashSet<>();
            
             max = 0 ;
            
            int curr = subtree.iterator().next();
            visited.add(curr);
            int depth = dfs(graph, curr, visited, subtree);
                
            ans[max - 1]++;
            
           
        }
        
                
            return ans;
    }
    
    public int dfs(Map<Integer, Set<Integer>> graph, int current, Set<Integer> visited, Set<Integer> subtree){
        int m1 = 0 , m2 = 0 ;
        int depth = 0 ;
        for(int i : graph.get(current)){
            if(!visited.contains(i) && subtree.contains(i)){
                visited.add(i);
                depth = dfs(graph, i, visited, subtree);
                 if(depth > m1){
                    m2 = m1;
                    m1 = depth;
                }
                else if(depth > m2){
                    m2 = depth;
                }
        
            }
        }
        
       
        max = Math.max(max, m1 + m2);
        
        return 1 + m1;
    }
}
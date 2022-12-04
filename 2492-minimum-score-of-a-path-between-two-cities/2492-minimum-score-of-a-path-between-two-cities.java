class Solution {
    
    public int minScore(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
       
        for(int[] road : roads){
           graph.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
           graph.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }
        
        Set<Integer> components = new HashSet<>();
        
        dfs(1, graph, components);
        int min = Integer.MAX_VALUE;
        
        for(int[] r : roads){
            if(components.contains(r[0]) && components.contains(r[1])){
                min = Math.min(min, r[2]);
            }
        }
       return min;
        
       
    }
    
    public void dfs(int curr, Map<Integer, Set<Integer>> graph, Set<Integer> components){
        components.add(curr);
        for(int i : graph.get(curr)){
            if(components.contains(i))
                continue;
            dfs(i, graph, components);
        }
    }
}

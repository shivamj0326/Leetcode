class Solution {
    long cost = 0 ;
    int seats;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        this.seats = seats;
        
        for(int i = 0 ; i <= roads.length; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        for(int i : graph.get(0)){
            dfs(i, graph, 0);
        }
        
        return cost;
    }
    
    public int dfs(int node, List<List<Integer>> graph, int prev){
        
        int people = 1;
        for(int i : graph.get(node)){
            if(i == prev)
                continue;
            
            people += dfs(i, graph, node);
            
        }

        cost += people/seats + (people % seats == 0 ? 0 : 1);
        return people;
        
        
    }
}
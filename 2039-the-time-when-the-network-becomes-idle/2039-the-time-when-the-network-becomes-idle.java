class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        int[] time = new int[n];
        q.offer(0);
        visited[0] = true;
        time[0] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size ; i++){
                int current = q.poll();
                for(int x : graph.get(current)){
                    if(!visited[x]){
                        time[x] = time[current] + 2;
                        visited[x] = true;
                        q.offer(x);
                    }
                }
            }
        }
        
        int max = 0, last = 0, packets = 0 ;
        
        for(int i = 0; i < n ; i++){
            last = 0 ;
            packets = 0;
            if(time[i] > patience[i]){
                packets = time[i]/patience[i];
                if(time[i] % patience[i] == 0)
                    packets--;
                last = packets * patience[i];
            }  
            max = Math.max(last + time[i], max);
        }
        return max + 1;
    }
    
    public List<List<Integer>> buildGraph(int[][] edges, int n){
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
}
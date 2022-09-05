class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        //time[i] : denotes the time taken by ith packet to reach zero and come back
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
                        //actual time includes return journey as well, hence +2 instead of +1
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
                // if patience[i] is multiple of time[i] then actual packets required will be 1 less
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
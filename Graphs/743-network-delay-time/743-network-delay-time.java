class Pair{
    int edge;
    int time;
    Pair(int edge, int time){
        this.edge = edge;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = 0, count = n;
        List<List<Pair>> graph = buildGraph(times, n);
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(k);
        time[k] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size ; i++){
                Integer current = q.poll();
                for(Pair x : graph.get(current)){
                    int tim = x.time;
                    int edge = x.edge;
                    int arrival = time[current] + tim;
                    if(arrival < time[edge]){
                        time[edge] = arrival;
                        q.offer(edge);
                    }    
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            max = Math.max(max, time[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    public List<List<Pair>> buildGraph(int[][] edges, int n){
        List<List<Pair>> graph = new ArrayList<>();
        
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<Pair>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        
        return graph;
    }
}
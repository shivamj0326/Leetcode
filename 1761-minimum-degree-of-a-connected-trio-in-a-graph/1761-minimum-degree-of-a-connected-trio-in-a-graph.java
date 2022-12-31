class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[] d = new int[n + 1];
        List<Set<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n ; i++){
            graph.add(new HashSet<>());
        }
        
        for(int[] e : edges){
            d[e[0]]++;
            d[e[1]]++;
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int sum = 0 , min = Integer.MAX_VALUE;
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = i + 1 ; j <= n ; j++){
                if(!graph.get(i).contains(j))
                    continue;
                for(int k = j + 1 ; k <= n ; k++){
                    
                    if(graph.get(i).contains(k) && graph.get(j).contains(k)){
                        sum = d[i] + d[j] + d[k] - 6;
                        min = Math.min(min, sum);
                    }
                        
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
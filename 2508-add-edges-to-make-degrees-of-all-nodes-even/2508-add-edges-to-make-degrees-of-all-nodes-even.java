class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i <= n ; i++){
            graph.add(new HashSet<Integer>());
        }
        int[] degree = new int[n + 1];
        for(int i = 0 ; i < edges.size(); i++){
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            degree[x]++;
            degree[y]++;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(degree[i] % 2 != 0){
                res.add(i);
            }
        }
        count = res.size();
        
        if(count > 4 || count % 2 == 1)
            return false;
        if(count == 0)
            return true;
        
        if(count == 4){
            if((!graph.get(res.get(0)).contains(res.get(1)) && !graph.get(res.get(2)).contains(res.get(3))) ||
               (!graph.get(res.get(0)).contains(res.get(2)) && !graph.get(res.get(1)).contains(res.get(3))) ||
               (!graph.get(res.get(0)).contains(res.get(3)) && !graph.get(res.get(1)).contains(res.get(2))))
                return true;
            else
                return false;        
        }
        
        if(count == 2){
            if(!graph.get(res.get(0)).contains(res.get(1)))
                return true;
            else{
                int x = res.get(0);
                int y = res.get(1);
                for(int i = 1 ; i <= n ; i++){
                    if(i == x || i == y)
                        continue;
                    if(!graph.get(i).contains(x) && !graph.get(i).contains(y))
                        return true;
                }
                return false;
            }
        }
        
        return false;
    }
}
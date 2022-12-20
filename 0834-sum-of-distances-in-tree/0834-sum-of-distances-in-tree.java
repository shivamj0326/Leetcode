class Solution {
    int[] res, count;
    List<Set<Integer>> graph;
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        res = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        
        graph = new ArrayList<Set<Integer>>();
        
        for(int i = 0 ; i < n ; i++){
            graph.add(new HashSet<Integer>());
        }
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
       
        postorder(0, -1);
        preorder(0, -1);
        
        return res;
    }
    
    public void postorder(int root, int par){
        for(int x : graph.get(root)){
            if(x == par)
                continue;
            postorder(x, root);
            count[root] += count[x];
            res[root] += res[x] + count[x];
        }
        
    }
    
    public void preorder(int root, int par){
        for(int x : graph.get(root)){
            if(x == par)
                continue;
            
            res[x] = res[root] + n - 2 * count[x];
            preorder(x, root);
        }
    }
    
    
}
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        
        boolean[] ans = new boolean[requests.length];
        int i = 0 ;
        
    
        for(int[] request : requests){
            int m = request[0];
            int c = request[1];
            int x = uf.find(m);
            int y = uf.find(c);
            boolean valid = true;
            if(!uf.isConnected(request[0], request[1])){
                for(int[] res : restrictions){
                    int p = uf.find(res[0]);
                    int q = uf.find(res[1]);
                    if((x == p && y == q) || (x == q && y == p)){
                        valid = false;
                        break;
                    }         
                }
            }
            ans[i++] = valid; 
            if(valid)
                uf.union(m, c);
        }
       
        return ans;
    }
}

class UnionFind{
    private int[] root;
    private int[] rank;
    
    UnionFind(int n){
        root = new int[n];
        rank = new int[n];
        
        for(int i = 0 ; i < n ; i++){          
            root[i] = i;
        }
    }
    
    public int find(int x){
        if(x != root[x])
            return root[x] = find(root[x]);
        return root[x] ;
    }
    
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY)
            return;
        
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }
        else if(rank[rootY] > rank[rootX]){
            root[rootX] = rootY;
        }
        else{
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
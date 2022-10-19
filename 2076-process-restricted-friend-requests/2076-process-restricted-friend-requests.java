class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] ans = new boolean[requests.length];
        UnionFind uf = new UnionFind(n);
        
        for(int i=0; i<requests.length; i++) {
            int u = requests[i][0], v = requests[i][1];
            int up = uf.find(u), vp = uf.find(v);
            ans[i] = true;
            
            for(int[] restriction : restrictions) {
                int x = restriction[0], y = restriction[1];
                int xp = uf.find(x), yp = uf.find(y);
                
                if( (xp == up && yp == vp) || (yp == up && xp == vp) ) {
                    ans[i] = false;
                    break;
                } 
            }
            if( ans[i] )
                uf.union(up, vp);
        }
        return ans;
    }
}
class UnionFind {
    private int[] root, rank;
    
    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++)
            root[i] = i;
           
    }
    
    public int find(int x) {
        if( root[x] != x )
            root[x] = find(root[x]);
        return root[x];
    }
    
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        
        if( px == py ) return false;
        
        if( rank[py] > rank[px] ) 
            root[px] = py;
        else if( rank[px] > rank[py] )
            root[py] = px;
        else {
            root[py] = px;
            rank[px] += 1;
        }
        return true;
    }
}
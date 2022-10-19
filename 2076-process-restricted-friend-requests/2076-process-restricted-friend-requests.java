class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] ans = new boolean[requests.length];
        DSU dsu = new DSU(n);
        
        for(int i=0; i<requests.length; i++) {
            int u = requests[i][0], v = requests[i][1];
            int up = dsu.find(u), vp = dsu.find(v);
            ans[i] = true;
            
            for(int[] restriction : restrictions) {
                int x = restriction[0], y = restriction[1];
                int xp = dsu.find(x), yp = dsu.find(y);
                
                if( (xp == up && yp == vp) || (yp == up && xp == vp) ) {
                    ans[i] = false;
                    break;
                } 
            }
            if( ans[i] )
                dsu.union(up, vp);
        }
        return ans;
    }
}
class DSU {
    private int[] parent, rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++)
            parent[i] = i;
    }
    
    public int find(int x) {
        if( parent[x] != x )
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        
        if( px == py ) return false;
        
        if( rank[py] > rank[px] ) 
            parent[px] = py;
        else if( rank[px] > rank[py] )
            parent[py] = px;
        else {
            parent[py] = px;
            rank[px] += 1;
        }
        return true;
    }
}
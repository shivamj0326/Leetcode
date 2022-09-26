class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        int n = equations.length;
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) -'a');
            }
        }
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                 if(uf.isConnected(eq.charAt(0) - 'a', eq.charAt(3) - 'a'))
                     return false;
            }
        }
        return true;
    }
}
class UnionFind{
    private int[] root;
    private int[] rank;

    UnionFind(int n){
        root = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            root[i] = i ;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootY] > rank[rootX])
                root[rootX] = rootY;
            else{
                root[rootY] = rootX ;
                rank[rootX] += 1;
            }      
        }
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }


}
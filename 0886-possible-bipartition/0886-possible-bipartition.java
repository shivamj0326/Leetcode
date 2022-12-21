class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int ni = dislikes.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < ni ; i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for(int i = 1 ; i <= n ; i++){
            if(color[i] == -1){
                if(!possibleColor(color, i, 1, adj))
                    return false;
            }
        }
        return true;
    }
    public boolean possibleColor(int[] color, int i, int c, List<List<Integer>> adj){
        color[i] = c;
        for(int x : adj.get(i)){
            if(color[x] == -1){
                possibleColor(color, x, 1 - c, adj);
                }
            else if(color[x] == color[i])
                return false;
        }
        return true;
        
        
    }
}
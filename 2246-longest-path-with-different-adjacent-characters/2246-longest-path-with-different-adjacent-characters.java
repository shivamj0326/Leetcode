class Solution {
    public int ans;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < parent.length ; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 1 ; i < parent.length ; i++){
            graph.get(parent[i]).add(i);
        }
        ans = Integer.MIN_VALUE;
        dfs(0, graph, s);
        return ans;
    }
    public int dfs(int src, List<List<Integer>> graph, String s){
        int max1 = 0 , max2 = 0 ;
        for(int x : graph.get(src)){
            int max = dfs(x, graph, s);
            if(s.charAt(src) != s.charAt(x)){
                if(max > max1){
                    max2 = max1;
                    max1 = max;
                }
                else if(max > max2){
                    max2 = max;
                }
            }
        }
        ans = Math.max(max1 + max2 + 1, ans);
        return max1 + 1;
    }
}
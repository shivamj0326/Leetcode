class Solution {
    private long max;
    private ArrayList<Integer>[] tree;
    private int[] price;
    private HashMap<String, Long> memo;
    
    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        memo = new HashMap<>();
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i].size() == 1) {
                long temp = helper(-1, i);
                res = Math.max(res, temp - price[i]);
            }
        }
        return res;
    }
    
    private long helper(int parent, int node) {
        String key = parent + " " + node;
        if (memo.containsKey(key)) return memo.get(key);
        
        long res = price[node];
        for (int child : tree[node]) {
            if (child != parent) {
                res = Math.max(res, price[node] + helper(node, child));
            }
        }
        
        memo.put(key, res);
        return res;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {   
        prepareGraph(root, map);
        if(map.size() == 1)
            return 0 ;
        return height(start, -1);
    }
    
    public void prepareGraph(TreeNode root, Map<Integer, List<Integer>> map){
        if(root == null)
            return;
        int val = root.val;
        if(root.left != null){
            int left = root.left.val;
            List<Integer> pn;
            List<Integer> np ;
            if(map.containsKey(val)){
                pn = map.get(val);
                pn.add(left);
            }
            else{
                pn = new ArrayList<Integer>();
                pn.add(left);     
            }
            
            if(map.containsKey(left)){
                np = map.get(left);
                np.add(val);
            }
            else{
                np = new ArrayList<Integer>();
                np.add(val);     
            }
            map.put(val, pn);
            map.put(left, np);
            
        }
        if(root.right != null){
            int right = root.right.val;
           
            List<Integer> pn;
            List<Integer> np ;
            if(map.containsKey(val)){
                pn = map.get(val);
                pn.add(right);
            }
            else{
                pn = new ArrayList<Integer>();
                pn.add(right);     
            }
            
            if(map.containsKey(right)){
                np = map.get(right);
                np.add(val);
            }
            else{
                np = new ArrayList<Integer>();
                np.add(val);     
            }
            map.put(val, pn);
            map.put(right, np);
        }
        
        prepareGraph(root.left, map);
        prepareGraph(root.right, map);
    }
    
    public int height(int root, int parent){
        
        int max = 0;
        
        for(int x : map.getOrDefault(root, new ArrayList<Integer>())){
            if(parent == x)
                continue;
            int height = height(x, root) + 1;
            max = Math.max(max, height);
        }
        
        return max;
    }
}
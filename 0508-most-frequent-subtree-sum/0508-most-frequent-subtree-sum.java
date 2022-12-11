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
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        solve(root, map);
        
        int max = Collections.max(map.values());
        
        for(int i : map.keySet()){
            if(map.get(i) == max){
                res.add(i);
            }
        }
        
        return res.stream().mapToInt(i->i).toArray();
        
    }
    
    public int solve(TreeNode root, Map<Integer, Integer> map){
        if(root == null)
            return 0 ;
        
        int left = solve(root.left, map);
        int right = solve(root.right, map);
        
        int sum = left + right + root.val;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
    
    
}
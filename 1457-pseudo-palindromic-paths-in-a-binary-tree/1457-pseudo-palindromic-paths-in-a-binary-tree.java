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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodes = new HashSet<>();
        dfs(root, nodes);
        return ans;        
    }
    
    public void dfs(TreeNode root, Set<Integer> nodes){
        if(root == null)
            return;
        if(nodes.contains(root.val))
            nodes.remove(root.val);
        else{
            nodes.add(root.val);
        }
            
        if(root.left == null && root.right == null){
            if(nodes.size() <= 1){
                ans++;
            }
        }
            
        dfs(root.left, new HashSet<>(nodes));
        dfs(root.right, new HashSet<>(nodes));
    }
}
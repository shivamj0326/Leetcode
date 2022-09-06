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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }
    
    public void dfs(TreeNode root, List<String> res, String current){
        if(root == null)
            return ;
        current += root.val;
        
        if(root.left == null && root.right == null){
            res.add(current);
            return;
        }
        
        current += "->";
        dfs(root.left, res, current);
        dfs(root.right, res, current);
            
    }
}
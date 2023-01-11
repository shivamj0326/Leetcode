/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        int val = target.val;
        
        return dfs(cloned, val);
   
        
    }
    
    TreeNode dfs(TreeNode root, int val){
        if(root == null)
            return null;
        
        if(root.val == val)
            return root;
        
        TreeNode left = dfs(root.left, val);
        TreeNode right = dfs(root.right, val);
        
        if(left != null && left.val == val)
            return left;
        if(right != null && right.val == val)
            return right;
        
        return null;
    }
}
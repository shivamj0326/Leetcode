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
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        
        solve(root);
        return max;
    }
    
    public int solve(TreeNode root){
        if(root == null)
            return 0 ;
        
        int left = 0 , right = 0 ;
        
        if(root.left != null)
            left = 1 + solve(root.left);
        
        if(root.right != null)
            right = 1 + solve(root.right);
        
        max = max = Math.max(left + right, max);
        
        return Math.max(left, right);
    }
}
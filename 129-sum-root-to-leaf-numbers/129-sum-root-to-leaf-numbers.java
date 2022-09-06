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
    int max = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return max;
    }
    
    public void dfs(TreeNode root, int base){
        if(root == null){
            return;
        }
        int newbase = 10 * base + root.val;
        if(root.right == null && root.left == null){
            max += newbase;
        }
        dfs(root.right, newbase);
        dfs(root.left, newbase);
        
    }
}
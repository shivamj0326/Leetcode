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
    int sum = 0 ;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    public void dfs(TreeNode root, int current){
        if(root == null){
            return;
        }
        current = ((current << 1) | root.val);
        //System.out.println(current);
        
        if(root.left == null && root.right == null){
            sum += current;
            return;
        }
        
        dfs(root.left, current);
        dfs(root.right, current);
        
    }
}
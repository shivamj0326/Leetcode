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
        int path = 0 ;
        dfs(root, path);
        return ans;        
    }
    
    public void dfs(TreeNode root, int path){
        if(root == null)
            return;
        path = path ^ (1 << root.val);
        
            
        if(root.left == null && root.right == null){
            if(path == 0 || (path & (path - 1)) == 0){
                ans++;
            }
        }
            
        dfs(root.left, path);
        dfs(root.right, path);
    }
}
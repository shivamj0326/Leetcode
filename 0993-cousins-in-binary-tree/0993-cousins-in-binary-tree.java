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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] par = new int[101];
        int[] depth = new int[101];
        
        dfs(root, -1, par, depth, 0);
        
       
       
        if(depth[x] == depth[y] && par[x] != par[y])
            return true;
        return false;
    }
    
    public void dfs(TreeNode root, int par, int[] p, int[] d, int depth){
       
        p[root.val] = par;
        
        //System.out.println(root.val + " " + p[root.val]);
        d[root.val] = depth;
        if(root.left != null)
            dfs(root.left, root.val, p, d, depth + 1);
        if(root.right != null)
            dfs(root.right, root.val, p, d, depth + 1);
    }
}
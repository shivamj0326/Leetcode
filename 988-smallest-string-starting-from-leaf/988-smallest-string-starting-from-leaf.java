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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    private String dfs(TreeNode node, String res){
        if(node == null)
            return "|";
        
        // time complexity: O(L), length of the ```res``` / O(H), height of the tree
        res = "" + (char)('a' + node.val) + res;
        
        if(isLeaf(node))
            return res;
        
        String left = dfs(node.left, res);
        String right = dfs(node.right, res);
        
        return left.compareTo(right) < 0 ? left : right;
    }
    
    private boolean isLeaf(TreeNode node){
        if(node == null) return false;
        
        return node.left == null && node.right == null;
    }
}
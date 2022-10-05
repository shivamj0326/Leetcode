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
    int depth ;
    int val;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.depth = depth;
        this.val = val;
        
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        addOneRowHelper(root, 1);
        return root;
    }
    
    public void addOneRowHelper(TreeNode root, int currentDepth){
        if(root == null)
            return;
      
        if(currentDepth == depth - 1){
            TreeNode left = root.left;
            TreeNode nodeLeft = new TreeNode(val);
            root.left = nodeLeft;
            nodeLeft.left = left;
            
            TreeNode right = root.right;
            TreeNode nodeRight = new TreeNode(val);
            root.right = nodeRight;
            nodeRight.right = right;
            return;
        }
        addOneRowHelper(root.left, currentDepth + 1);
        addOneRowHelper(root.right, currentDepth + 1);
    }
}
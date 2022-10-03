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
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++){
            inorderMap.put(inorder[i], i);
        }
       return buildTreeHelper(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int left, int right){
        if(left > right)
            return null;
        int root = preorder[preorderIndex++];
        
        TreeNode node = new TreeNode(root);
        
       
        node.left = buildTreeHelper(preorder, left, inorderMap.get(root) - 1);
        node.right = buildTreeHelper(preorder, inorderMap.get(root) + 1 , right);
        
        return node;
    }
}
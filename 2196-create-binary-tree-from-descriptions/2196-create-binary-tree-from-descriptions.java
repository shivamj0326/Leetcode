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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int[] d : descriptions){
            TreeNode node = map.getOrDefault(d[0], new TreeNode(d[0]));
            if(d[2] == 1){
                node.left = map.getOrDefault(d[1], new TreeNode(d[1]));
                map.put(node.left.val, node.left);
                children.add(node.left.val);
            }
            else{
                node.right = map.getOrDefault(d[1], new TreeNode(d[1]));
                map.put(node.right.val, node.right);
                children.add(node.right.val);
            }
            map.put(node.val, node);
            
        }
        
        for(int[] d : descriptions){
            if(!children.contains(d[0])){
                root = map.get(d[0]);
            }
        }
        return root;
        
    }
    
   
}
                 

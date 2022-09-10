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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        boolean leftToRight = true;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            while(leftToRight && !s1.isEmpty()){
                List<Integer> currentList = new ArrayList<>();
                int len = s1.size();
                
                for(int i = 0 ; i < len; i++){
                    TreeNode current = s1.pop();
                    currentList.add(current.val);
                
                    if(current.left != null)
                        s2.push(current.left);
                
                    if(current.right != null)
                        s2.push(current.right);
                    
                }
                res.add(currentList);
                leftToRight = !leftToRight;
            }
             while(!leftToRight && !s2.isEmpty()){
                List<Integer> currentList = new ArrayList<>();
                int len = s2.size();
           
                for(int i = 0 ; i < len; i++){
                    TreeNode current = s2.pop();
                    currentList.add(current.val);
                    
                    if(current.right != null)
                        s1.push(current.right);
                
                    if(current.left != null)
                        s1.push(current.left);
                    
                }
                res.add(currentList);
                leftToRight = !leftToRight;
            }
            
        }
        
        return res;
    }
}
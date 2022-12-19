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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max = 0, cur = 0 ;
        Map<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0, end = 0;
            
            for(int i = 0 ; i < size; i++){
                TreeNode current = q.poll();
                if(i == 0)
                    start = map.get(current);
                if(i == size - 1)
                    end = map.get(current);
                
                if(current.left != null){
                    map.put(current.left, map.get(current) * 2);
                    q.offer(current.left);
                }
                if(current.right != null){
                    map.put(current.right, map.get(current) * 2 + 1);
                    q.offer(current.right);
                }
                
            }
            cur = end - start + 1;
            
            max = Math.max(max, cur);
    
        }
        
        return max;
    }
}
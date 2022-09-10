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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        boolean flag = false;
        q.offer(root);
        
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> currentList = new ArrayList<>();
            for(int i = 0 ; i < len; i++){
                TreeNode current = q.poll();
                if(flag)
                    currentList.add(0,current.val);
                else
                    currentList.add(current.val);
                
                if(current.left != null)
                    q.offer(current.left);
                
                if(current.right != null)
                    q.offer(current.right);
                    
            }
            
            res.add(currentList);
            flag = !flag;
            
        }
        return res;
    }
}
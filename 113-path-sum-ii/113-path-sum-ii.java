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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> subres = new ArrayList<>();
        pathSumHelper(root, targetSum, new ArrayList<>());
        return res;
        
    }
    public void pathSumHelper(TreeNode root, int target, List<Integer> subres){
        if(root == null)
            return ;
        
        int rem = target - root.val ;
        subres.add(root.val);
        if(rem == 0 && root.left == null && root.right == null){
            res.add(subres);
            return ;
        }
        pathSumHelper(root.left, rem, new ArrayList<>(subres));
        pathSumHelper(root.right, rem, new ArrayList<>(subres));
    }
}
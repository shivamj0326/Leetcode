/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                Node current = q.poll();
                level.add(current.val);
                for(Node child : current.children){
                    if(child != null){
                        q.offer(child);
                    }   
                }
            }
            ans.add(level);    
        }
        return ans;
    }
}

/*
DFS:
 class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> traversal = new ArrayList<>();
        traverse(root, traversal, 0);
        return traversal;
    }
    
    private void traverse(Node node, List<List<Integer>> traversal, int level) {
        if (node == null) {
            return;
        }
        
        if (traversal.size() == level) {
            traversal.add(new ArrayList<>());
        }
        traversal.get(level).add(node.val);
        
        for (Node child : node.children) {
            traverse(child, traversal, level + 1);
        }
    }
}
*/

Time Complexity : O(n)
Space Complexity : O(n)

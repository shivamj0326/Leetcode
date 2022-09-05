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
    public int maxDepth(Node root) {
        
        int depth = 0;
        
        if(root == null)
            return depth;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){

            int size = q.size(); 
            for(int i = 0 ; i < size; i++){
                Node current = q.poll();
                for(Node child : current.children){
                    if(child != null){
                        q.offer(child);
                    }   
                }
            }
            depth++;  
        }
        return depth;
    }
}

Time Complexity : O(n)
Space Complexity : O(n)


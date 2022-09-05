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
                                                      
Time Complexity : O(n)
Space Complexity : O(n)                                                      

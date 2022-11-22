class Solution {
    public int numSquares(int n) {
        
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0 ;
        
        q.offer(n);
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            
            for(int i = 0 ; i < size; i++){
                int rem = q.poll();
                
                for(int j = 1 ; j * j <= rem; j++){
                    
                    if(rem - j * j == 0)
                        return level;
                    if(!visited.contains(rem - j * j)){
                        visited.add(rem - j * j);
                        q.offer(rem - j * j);
                    }
                }
            }
        }
        return n;
    }   
}
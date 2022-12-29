class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        int[][] t = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            t[i][0] = i;
            t[i][1] = tasks[i][0];
            t[i][2] = tasks[i][1];
        }
        
        Arrays.sort(t, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] res = new int[n];
        
        int i = 0, index = 0, currentTime = 0 ;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        // q.offer(t[0]);
        // currentTime = t[0][1];
        // currentTime += t[0][2];
        
        while(i < n){
            
            while(i < n && currentTime >= t[i][1]){
                q.offer(t[i++]);
            }
            
            if(q.isEmpty()){
                currentTime = t[i][1];
               // q.offer(t[i++]);
                continue;
            }
            
            res[index++] = q.peek()[0];
            currentTime += q.peek()[2];
            q.poll();      
            
        }
        
        while(!q.isEmpty()){
            res[index++] = q.poll()[0];
        }
        
        return res;
    }
}
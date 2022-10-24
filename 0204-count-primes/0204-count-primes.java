class Solution {
    public int countPrimes(int n) {
        int[] visited = new int[n] ;
        int count = 0;
        
        for(int i = 2 ; i < n ; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                count++;
                for(int j = 2*i ; j < n ; j = j + i){
                    visited[j] = -1;   
                }
            }         
        }
        
        return count;
        
    }
}
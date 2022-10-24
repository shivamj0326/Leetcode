class Solution {
    public int countPrimes(int n) {
        int[] visited = new int[n + 1] ;
        int count = 0;
        
        for(int i = 2 ; i < n ; i++){
            if(visited[i] == 0){
                count++;
                for(long j = (long)i*i ; j < n ; j = j + i){
                    visited[(int)j] = -1;   
                }
            }         
        }
        return count;
        
    }
}
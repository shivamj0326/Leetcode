class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ; i <= n + 1; i++){
            q.offer(i);
        }
        int left = -1 ;
        StringBuilder sb = new StringBuilder(pattern + " ");
        
        for(int i = 0 ; i < n ; i++){
            char ch = pattern.charAt(i);
            if(ch == 'I'){
                sb.setCharAt(i, (char)(q.poll() + 48));
                for(int j = i - 1 ; j > left ; j--){
                    sb.setCharAt(j, (char)(q.poll() + 48));
                }
                left = i ;
            }  
        }
        
        for(int i = n ; i > left ; i--){
            sb.setCharAt(i, (char)(q.poll() + 48));
        }
        return sb.toString();
        
        
    }
}
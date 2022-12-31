class Solution {
    public int minimumMoves(String s) {
        int n = s.length(), count = 0;
        int i = 0;
        while(i < n){
            if(s.charAt(i) == 'O'){
                i++;
                continue;
            }
            else{
                i = i + 3;
                count++;
            }
        }
        
        return count;
    }
}
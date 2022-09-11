class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        
        int min = 0 , left = -1;
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                ans[i] = min++;
                for(int j = i  - 1 ; j > left; j--){
                    ans[j] = min++;
                }
                left = i;
            }
        }
        
        for(int j = n ; j > left; j--){
            ans[j] = min++;
        }
        return ans;
    }
}
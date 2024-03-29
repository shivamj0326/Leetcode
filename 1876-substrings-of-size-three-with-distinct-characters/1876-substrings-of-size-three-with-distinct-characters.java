class Solution {
    public int countGoodSubstrings(String s) {
       int[] count = new int[26];
        int duplicates = 0 , n = s.length(), ans = 0;
        for(int i = 0 ; i < n ; i++){

            if(++count[s.charAt(i) - 'a'] == 2)
                duplicates++;
            if(i < 2)
                continue;
            if(i >= 3 && --count[s.charAt(i - 3) - 'a'] == 1){
                    duplicates--;
            }
            if(i >= 2 && duplicates == 0)
                ans++;
        }
        
        return ans;
    }
}
class Solution {
    public long countVowels(String word) {
        long res = 0 ;
        
        int n = word.length();
        
        for(int i = 0 ; i < n; i++){
            int x = "aeiou".indexOf(word.charAt(i));
            if(x >= 0)
                res += (long)(i + 1) * (n - i);
        }
        
        return res;
    }
}
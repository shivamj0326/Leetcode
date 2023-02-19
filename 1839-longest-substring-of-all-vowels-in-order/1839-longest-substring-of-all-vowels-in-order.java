class Solution {
    public int longestBeautifulSubstring(String word) {
        int vowels = 0, len = 0, n = word.length(), max = 0;
        
        
        for(int i = 0 ; i < n ; i++){
            if(i != 0 && word.charAt(i - 1) > word.charAt(i)){
                vowels = 0;
                len = 0;
            }
            len++;
            if(i == 0 || word.charAt(i) != word.charAt(i - 1))
                vowels++;
            
            if(vowels == 5){
                max = Math.max(max, len);
            }
        }
        
        return max;
        
    }
}
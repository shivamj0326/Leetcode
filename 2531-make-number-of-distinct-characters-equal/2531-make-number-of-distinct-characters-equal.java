class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for(char ch : word1.toCharArray()){
            f1[ch - 'a']++;
        }
        
        for(char ch : word2.toCharArray()){
            f2[ch - 'a']++;
        }
        
        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < 26; j++){
                if(f1[i] > 0 && f2[j] > 0){
                     f1[i]--;
                f2[i]++;
                f2[j]--;
                f1[j]++;
            
                int l = 0, r = 0;
                
                for(int k = 0 ; k < 26; k++){
                    if(f1[k] > 0)
                        l++;
                    if(f2[k] > 0)
                        r++;
                }
                if(l == r)
                    return true;
                f1[i]++;
                f2[i]--;
                f1[j]--;
                f2[j]++;
                }
               
               
            }
        }
        
        return false;
    }
}
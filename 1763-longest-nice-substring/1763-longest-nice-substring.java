class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length() < 2)
            return "";
        
        char ch[] = s.toCharArray();
        
        Set<Character> set = new HashSet<>();
        
        for(char c : ch){
            set.add(c);
        }
        
        for(int i = 0 ; i < ch.length; i++){
            if(set.contains(Character.toLowerCase(ch[i])) && set.contains(Character.toUpperCase(ch[i])))
                continue;
            
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        
        return s;
    }
    
}
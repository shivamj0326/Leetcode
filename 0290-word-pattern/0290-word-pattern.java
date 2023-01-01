class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] w = s.split(" ");
        
        int n = pattern.length();
        
        if(n != w.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> res = new HashMap<>();
       
        for(int i = 0 ; i < n ; i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(w[i]))
                    return false;
            }
            
            if(res.containsKey(w[i])){
                if(!res.get(w[i]).equals(ch))
                    return false;
            }
           // System.out.println(w[i]);
            
            map.put(ch, w[i]);
            res.put(w[i], ch);
        }
        
        return true;
    }
}
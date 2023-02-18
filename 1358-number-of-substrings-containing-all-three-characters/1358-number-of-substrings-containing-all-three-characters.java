class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0 ;
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.size() >= 3){
                char rm = s.charAt(left);
                map.put(rm, map.get(rm) - 1);
                if(map.get(rm) == 0)
                    map.remove(rm);
                left++;
                
            }
            res += left;
            
        }
        
        return res;
    }
}
class Solution {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int n = s.length();
        char prev ;
        
        if(n < 3)
            return 0 ;
        
        for(int i = 0 ; i <= 2 ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size() == 3 ? 1 : 0;
        for(int i = 3 ; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            prev = s.charAt(i - 3);
            map.put(prev, map.get(prev) - 1);
            if(map.get(prev) == 0)
                map.remove(prev);
            if(map.size() == 3)
                count++;
        }
        return count;
    }
}
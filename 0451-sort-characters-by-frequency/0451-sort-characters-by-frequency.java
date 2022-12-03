class Solution {
    public String frequencySort(String s) {
       Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.val - a.val);
        
        for(char ch : map.keySet()){
            q.offer(new Pair(ch, map.get(ch)));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for(int i = 0 ; i < p.val ; i++){
                sb.append(p.chars);
            }
        }
        
        return sb.toString();
        
    }
    
}

class Pair{
    int val;
    char chars;
    
    Pair(char chars, int val){
        this.chars = chars;
        this.val = val;
    }
}
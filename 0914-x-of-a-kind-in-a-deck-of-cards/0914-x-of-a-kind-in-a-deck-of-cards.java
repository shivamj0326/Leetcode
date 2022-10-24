class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0 ; i < deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        
        for(int x : map.keySet()){
            res = gcd(map.get(x), res);
        }
        
        return res > 1;
    }
    
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}
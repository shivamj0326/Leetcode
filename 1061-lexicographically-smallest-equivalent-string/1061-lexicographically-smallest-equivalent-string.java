class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        DSU dsu = new DSU();
        for(int i = 0 ; i < s1.length() ; i++){
            dsu.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < baseStr.length(); i++){
            sb.append((char)('a' + dsu.find(baseStr.charAt(i) - 'a')));
        }
        
        return sb.toString();
    }
}

class DSU{
    int[] root ;
    
    DSU(){
        root = new int[26];
        
        for(int i = 0 ; i < 26; i++){
            root[i] = i;
        }
    }
    
     int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
  
    }
    
    void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        
        if (x < y) {
            root[y] = x;
        } else {
            root[x] = y;
        }
    }
}
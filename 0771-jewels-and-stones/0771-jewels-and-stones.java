class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0 ;
        // int m = stones.length();
        // int n = jewels.length();
        // for(char c : jewels.toCharArray()){
        //     for(int i = 0 ; i < m ; i++){
        //         if(stones.charAt(i) == c)
        //             ans++;
        //     }
        // }
        Set<Character> set = new HashSet();
        for(char j : jewels.toCharArray()){
            set.add(j);
        }
        for(char s : stones.toCharArray()){
            if(set.contains(s))
                ans++;
        }
        return ans ;
    }
}
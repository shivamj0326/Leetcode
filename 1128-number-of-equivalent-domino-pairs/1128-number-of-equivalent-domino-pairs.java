class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(int[] d : dominoes){
            int max = Math.max(d[0], d[1]);
            int min = Math.min(d[0], d[1]);
            
            map.put(max + " " + min, map.getOrDefault(max + " " + min, 0) + 1);
        }
        
        for(int i : map.values()){
            res += (i * (i - 1))/2;
        }
        return res;
    }
}
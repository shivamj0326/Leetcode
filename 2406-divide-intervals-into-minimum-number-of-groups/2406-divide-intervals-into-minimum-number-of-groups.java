class Solution {
    public int minGroups(int[][] p) {
        int n = p.length;
        int[] count = new int[1000002];
        
        for(int[] i : p){
            count[i[0]]++;
            count[i[1] + 1]--;
        }
        int res = 0 , current = 0;
        
        for(int i = 0 ; i < count.length; i++){
            res = Math.max(res, current += count[i]);
        }
        return res;
    }
}
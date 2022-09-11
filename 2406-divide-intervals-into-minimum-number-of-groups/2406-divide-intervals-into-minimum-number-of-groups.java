class Solution {
    public int minGroups(int[][] p) {
        int n = p.length;
        Arrays.sort(p, (a, b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] count = new int[1000002];
        
        for(int[] i : p){
            count[i[0]]++;
            count[i[1] + 1]--;
        }
        int res = 0 , current = 0;
        
        for(int i = 1 ; i < count.length; i++){
            count[i] += count[i - 1];
            
            res = Math.max(res, count[i]);
        }
        return res;
    }
}
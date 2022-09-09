class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        int n = p.length;
        Arrays.sort(p, (a, b)->{
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int count = 0 ;
        int max = p[n - 1][1];
        for(int i = n - 2 ; i >= 0 ; i--){
            if(p[i][1] < max){
                count++;
            }
            max = Math.max(p[i][1], max);
        }
        
        return count;
            
            
    }
}
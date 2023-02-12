class Solution {
    public long putMarbles(int[] weights, int k) {
        long res = 0 ;
        int n = weights.length;
        long[] b = new long[n - 1];
        for(int i = 0 ; i < n - 1 ; i++){
            b[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(b);
        
        for(int i = 0 ; i < k - 1 ; i++){
            res += b[n - 2 - i] - b[i];
        }
        
        return res;
    }
}
class Solution {
    public long minOperations(int[] n1, int[] n2, int k) {
        
        int n = n1.length;
        long up = 0 , down = 0;
        
        for(int i = 0 ; i < n; i++){
            if(n1[i] == n2[i])
                continue;
            if(k == 0)
                return -1;
            else {
                int diff = Math.abs(n1[i] - n2[i]);
                if(diff % k != 0)
                    return -1;
                if(n1[i] > n2[i])
                    up += diff/k;
                else
                    down += diff/k;
            }

        }
        
        return up == down ? up : -1;
    }
}
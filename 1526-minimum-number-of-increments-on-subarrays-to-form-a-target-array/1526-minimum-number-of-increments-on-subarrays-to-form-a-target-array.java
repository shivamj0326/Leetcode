class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int max = 0, pre = 0, res = 0;
        
        for(int i : target){
            res += Math.max(i - pre, 0);
            pre = i;
        }
        
        return res;
    }
}
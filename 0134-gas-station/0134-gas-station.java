class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0, res = 0, total = 0;
        
        for(int i = 0 ; i < n ; i++){
            res += gas[i] - cost[i];
            total += gas[i] - cost[i];
            
            if(res < 0){
                start = i + 1;
                res = 0;
            }
        }
        
        if(total < 0)
            return -1;
        
        return start;
    }
}
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for(int i = 0 ; i < n ; i++){
            if(capacity[i] == 0)
                count++;
            else if(capacity[i] <= additionalRocks){
                additionalRocks -= capacity[i];
                count++;
            }
            if(additionalRocks == 0)
                break;
        }
        return count;
    }
}
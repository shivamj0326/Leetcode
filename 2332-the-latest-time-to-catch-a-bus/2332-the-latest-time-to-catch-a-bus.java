class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length, m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int ans = 0, j = 0, prev = 0;      
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            while(j < m && passengers[j] <= buses[i] && count < capacity){
                if(passengers[j] - prev > 1)
                    ans = passengers[j] - 1;
                prev = passengers[j];
                j++;
                count++;
            }
            
           if(count < capacity && buses[i] - prev >= 1)
               ans = buses[i];
        }
        
        return ans;
    }
}
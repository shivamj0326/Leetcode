class Solution {
    public int[] findOriginalArray(int[] nums) {
        int n = nums.length, i = 0;
        if(n % 2 == 1)
            return new int[0];
        
        int[] res = new int[n/2];
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : map.keySet()){
            if(map.get(num) > map.getOrDefault(2*num, 0)){
                return new int[0];
            }
            
            for(int j = 0 ; j < map.get(num); j++){
                res[i++] = num;
                map.put(2*num, map.get(2*num) - 1);
            }
        }
        return res;
    }
}
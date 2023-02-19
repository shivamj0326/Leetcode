class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int[] i : nums1){
            map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
        }
        
        for(int[] i : nums2){
            map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
        }
        
        int size = map.size();
        int count = 0 ;
        int[][] res = new int[size][2];
        
        for(int i : map.keySet()){
            res[count][0] = i;
            res[count][1] = map.get(i);
            count++;
        }
        
        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        return res;
    }
}
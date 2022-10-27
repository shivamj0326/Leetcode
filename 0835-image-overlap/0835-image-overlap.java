class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
        List<Integer> la = new ArrayList<>();
        
        List<Integer> lb = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n * n ; i++){
            if(img1[i/n][i % n] == 1)
                la.add(i/n * 100 + i % n);
            
            if(img2[i/n][i % n] == 1)
                lb.add(i/n * 100 + i % n);
        }
        
        for(int i : la){
            for(int j : lb){
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);
            }
        }
        
        int max = 0;
        
        for(int i  : map.values()){
            max = Math.max(max, i);
        }
        
        return max;
    }
}
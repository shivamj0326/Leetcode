class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<int[]> heights = new ArrayList<>();
        
        transform(buildings, heights);
        Collections.sort(heights, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        int preMax = 0 ;
        
        for(int[] h : heights){
            if(h[1] < 0){
                queue.offer(-h[1]);      
            }
            else{
                queue.remove(h[1]);
            }
            int currentMax = queue.peek();
            if(preMax != currentMax){
                List<Integer> subres = new ArrayList<>();
                subres.add(h[0]);
                subres.add(currentMax);
                res.add(subres);
                preMax = currentMax;
            }
        }
        return res;       
    }
    
    private void transform(int[][] buildings, List<int[]> heights){
        for(int[] building : buildings){
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
    }
}
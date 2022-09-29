
class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) ->  {if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];});
        
        for(int i : arr){
            queue.offer(new int[]{Math.abs(i - x), i});
            
        }
        
        for(int i = 0 ; i < k ; i++){
            ans.add(queue.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}
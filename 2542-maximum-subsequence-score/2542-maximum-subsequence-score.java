class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res = 0, sum  = 0 ;
        int n = nums1.length;
        Pair[] p = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            p[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(p, (a, b) -> b.first - a.first);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.second - b.second);
        
        for(int i = 0 ; i < n ; i++){
            q.offer(p[i]);
            sum += p[i].first;
            if(q.size() > k)
                sum -= q.poll().first;
            if(q.size() == k)
                res = Math.max(res, sum * q.peek().second);
            
        }
        
        return res;
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
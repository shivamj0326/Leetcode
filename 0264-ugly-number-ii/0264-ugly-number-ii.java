class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        q.offer(1);
        
        while(!q.isEmpty()){
            int current = q.poll();
            count++;
            if(count == n)
                return current;
            if(current <= Integer.MAX_VALUE/2 && visited.add(current * 2))
                q.offer(current * 2);
            if(current <= Integer.MAX_VALUE/3  && visited.add(current * 3))
                q.offer(current * 3);
            if(current <= Integer.MAX_VALUE/5  && visited.add(current * 5))
                q.offer(current * 5);
        }
        
        return -1;
    }
}
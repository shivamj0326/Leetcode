class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        int count = 1 ;
        for(int[] i : intervals){
            if(queue.isEmpty()){
                queue.offer(i[1]);
            }
            else if(queue.peek() > i[0]){
                count++;
                queue.offer(i[1]);
            }
            else{
                queue.poll();
                queue.offer(i[1]);
            }
        }
        return count;
    }
}
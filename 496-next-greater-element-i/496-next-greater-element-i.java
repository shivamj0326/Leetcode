class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < m ; i++){
            map.put(nums1[i], -1);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int j = n - 1 ; j >= 0 ; j--){
            int x = nums2[j];
            
            if(stack.size() > 0){
                while(stack.size() > 0 && stack.peek() <= x)
                    stack.pop();
                if(stack.size() != 0)
                    map.put(x, stack.peek());
            }  
            stack.push(x);
        }
        
        return Arrays.stream(nums1).map(i -> map.get(i)).toArray();
    }
}
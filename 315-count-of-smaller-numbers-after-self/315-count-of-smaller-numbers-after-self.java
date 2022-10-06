class Solution {
    
    private int[] segmentTree ;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        
        segmentTree = new int[8 * 100005];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            update(0, 0, 200000, nums[i] + 10000, 1);
            count[i] = query(0, 0, 200000, 0, nums[i] + 10000 - 1);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < count.length; i++){
            res.add(count[i]);
        }
        
        return res;
    }
    
    private void update(int pos, int left, int right, int index, int val){
        if(left == right){
            segmentTree[pos] += val;
            return;
        }
        
        int mid = left + (right - left)/2 ;
        
        if(index > mid)
            update(2 * pos + 2, mid + 1, right, index, val);
        else
            update(2 * pos + 1, left, mid, index, val);
        
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }
    
    private int query(int pos, int low, int high, int left, int right){
        if(high < left || low > right)
            return 0;
        if(low >= left && high <= right)
            return segmentTree[pos];
        
        int mid = low + (high - low)/2 ;
        
        int l = query(2 * pos + 1, low, mid, left, right);
        int r = query(2 * pos + 2, mid + 1, high, left, right);
        
        return l + r ;
    }
}
class Solution {
    int[] segmentTree;
    int n ;
    public int lengthOfLIS(int[] nums, int k) {
        n = nums.length;
        segmentTree = new int[4 * 100005];
        
        for(int i = 0 ; i < n ; i++){
            int low = Math.max(0, nums[i] - k);
            int count = query(0, 0, 100000, low, nums[i] - 1);
            update(0, 0, 100000, nums[i], count + 1);
        }
        
        return segmentTree[0];
    }
    
    private void update(int pos, int left, int right, int index, int val){
        if(left == right){
            segmentTree[pos] = Math.max(segmentTree[pos], val);
            return;
        }
        
        int mid = left + (right - left)/2 ;
        
        if(index > mid)
            update(2 * pos + 2, mid + 1, right, index, val);
        else
            update(2 * pos + 1, left, mid, index, val);
        
        segmentTree[pos] = Math.max(segmentTree[pos], Math.max(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]));
    }
    
    private int query(int pos, int low, int high, int left, int right){
        if(high < left || low > right)
            return 0;
        if(low >= left && high <= right)
            return segmentTree[pos];
        
        int mid = low + (high - low)/2 ;
        
        int l = query(2 * pos + 1, low, mid, left, right);
        int r = query(2 * pos + 2, mid + 1, high, left, right);
        
        return Math.max(l, r) ;
    }
}
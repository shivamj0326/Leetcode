class NumArray {
    
    int[] segmentTree;
    int[] arr;
    int n;

    public NumArray(int[] nums) {
        arr = nums;
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1);
    }
    
    public void update(int index, int val) {
        updateTreeHelper(0, 0, n - 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return querySumRange(0, 0, n - 1, left, right);
    }
    
    private void buildSegmentTree(int index, int left, int right){
        if(left == right){
            segmentTree[index] = arr[left];
            return ;
        }
        
        int mid = left + (right - left)/2 ;
        
        buildSegmentTree(2 * index + 1, left, mid);
        buildSegmentTree(2 * index + 2, mid + 1, right);
        
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }
    
    private int querySumRange(int index, int low, int high, int left, int right){
        if(low > right || high < left)
            return 0;
        
        if(low >= left && high <= right)
            return segmentTree[index];
        
        int mid = low + (high - low)/2 ;
        
        int l = querySumRange(2 * index + 1, low, mid, left, right);
        int r = querySumRange(2 * index + 2, mid + 1, high, left, right);
        return l + r ;
            
    }
    
    private void updateTreeHelper(int pos, int left, int right, int index, int val){
        if(left == right){
            segmentTree[pos] = val;
            return;
        }    
        
        int mid = left + (right - left)/2 ;
        
        if(index <= mid)
            updateTreeHelper(2 * pos + 1, left, mid, index, val);
        else
            updateTreeHelper(2 * pos + 2, mid + 1, right, index, val);
        
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
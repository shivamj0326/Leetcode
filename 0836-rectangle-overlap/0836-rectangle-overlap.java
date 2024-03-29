class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int y = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        
        if(x > 0 && y > 0)
            return true;
        else
            return false;
    }
}
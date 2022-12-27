class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int min = 0 , max = 0 ;
     
        for(int i : piles){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int l = 1, r = max;
        
        while(l < r){
            int mid = l + (r - l)/2;
            if(check(piles, mid, h)){
                r = mid;  
            }
            else{
                l = mid + 1;
            }
        }
        
        return l;
        
    }
    
    public boolean check(int[] p, int k, int h){
        int d = 0;
            
        for(int i : p){
           d += (i + k - 1)/k ;
        }
        return (d <= h);
    }
}
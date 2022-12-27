class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0 , max = 0 ;
        for(int w : weights){
            sum += w;
            max = Math.max(max, w);
        }
        
        int l = max, r = sum;
        
        while(l < r){
            int mid= l + (r - l)/2;
            
            if(check(weights, mid, days)){
                r = mid ;
            }
            else{
                l = mid + 1;
            }
        }
        
        return r;
    }
    
    public boolean check(int[] weights, int c, int days){
        int d = 1, current = 0 ;
        
        for(int w : weights){
            current += w;
            if(current > c){
                d++;
                current =  w;
            }
        }
        return (d <= days);
    }
}
class Solution {
    public boolean isReachable(int x, int y) {
        
        while(x != 1 && y != 1){
            
            x = divideBy2(x);
            y = divideBy2(y);
            
            if(x == 1 || y == 1)
                return true;
            
            else if(x == y)
                return false;
            
            else if(x < y){
                y = x + y;
            }
            
            else{
                x = x + y;
            }
            
        } 
        return true;   
    }
    
    int divideBy2(int x){
        while(x % 2 == 0)
            x = x/2;
        
        return x;
    }
}
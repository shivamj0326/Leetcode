class Solution {
    public boolean isRationalEqual(String s, String t) {
        return f(s) == f(t);
    }
    
    public double f(String s){
        int n = s.length();
        int index = s.indexOf('(');
        if(index > 0){
            String base = s.substring(0, index);
            String rep = s.substring(index + 1, n - 1);
            for(int j = 0 ; j < 20; j++){
                base += rep;
            }
            
            return Double.valueOf(base);
        }
        
        return Double.valueOf(s);
    }
}
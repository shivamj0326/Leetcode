class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        
        int m = -1;
        int p = -1;
        int g = -1;
        
        int cm = 0;
        int cp = 0;
        int cg = 0;
        
        for(int i = n - 1 ; i >= 0; i--){
            for(char ch : garbage[i].toCharArray()){
                if(ch == 'G'){
                    cg++;
                    if(g == -1){
                        g = i;
                    }
                }
                else if(ch == 'P'){
                    cp++;
                    if(p == -1){
                        p = i;
                    }
                }
                else{
                    if(m == -1){
                        m = i;
                    }
                    cm++;
                }
            }
        }
        
        for(int i = 1 ; i < n - 1 ; i++){
            travel[i] += travel[i - 1];
        }
        
        int sum = cm + cp + cg + (m < 1? 0 : travel[m - 1]) + ( g < 1 ? 0 : travel[g - 1]) + (p < 1 ? 0 : travel[p - 1]);
        return sum;
    }
}
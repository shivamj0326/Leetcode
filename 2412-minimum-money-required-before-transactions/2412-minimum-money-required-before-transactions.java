class Solution {
    public long minimumMoney(int[][] t) {
        int n = t.length;
        
        Arrays.sort(t, (a, b) -> {
            return a[1] - b[1];
        });
       long money = 0, max = 0 , min = 0;
        for(int i = 0 ; i < t.length ; i++){
            if(t[i][0] > t[i][1]){
                money += t[i][0];
                max = Math.max(max, money);
                money -= t[i][1];
                
            }
                
            else{
                min = Math.max(min, t[i][0]);
            }       
        }
        return Math.max(max, money + min) ;
    }
}
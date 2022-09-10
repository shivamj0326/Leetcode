class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] current = new int[2];
        int[] ahead = new int[2];
        
        ahead[0] = 0;
        ahead[1] = 0;
        
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1; j++){
                if(j == 1){
                    current[1] = Math.max(-prices[i] + ahead[0], ahead[1]);
                }
                else{
                    current[0] = Math.max(prices[i] + ahead[1], ahead[0]);
                }
            }
            ahead = current;
        }
        return ahead[1];
    }
}
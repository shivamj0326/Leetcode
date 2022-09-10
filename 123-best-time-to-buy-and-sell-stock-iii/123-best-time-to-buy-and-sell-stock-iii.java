class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n + 1][3][2];
        return solve(prices, 0 , 1, 2, dp);
    }
    
    public int solve(int[] prices, int index, int buy, int tx, Integer[][][] dp){
        if(tx == 0 || index == prices.length)
            return 0 ;
        
        if(dp[index][tx][buy] != null)
            return dp[index][tx][buy];
        
        int profit = 0 ;
        
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(prices, index + 1, 0, tx, dp), solve(prices, index + 1, 1, tx, dp));
        }
        else {
            profit = Math.max(prices[index] + solve(prices, index + 1, 1, tx - 1, dp), solve(prices, index + 1, 0, tx, dp));
        }
        return dp[index][tx][buy] = profit;
    }
}
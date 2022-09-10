class Solution {
    int fee;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n + 1][2];
        this.fee = fee;
        return solve(prices, 0, 1, dp);
    }
    
    public int solve(int[] prices, int index, int buy, Integer[][] dp){
        if(index == prices.length)
            return 0 ;
        
        if(dp[index][buy] != null)
            return dp[index][buy];
        int profit = 0 ;
        if(buy == 1){
            profit = Math.max(-prices[index] + solve(prices, index + 1, 1 - buy, dp),
                             solve(prices, index + 1, buy, dp));
        }
        else{
            profit = Math.max(prices[index] - fee + solve(prices, index + 1, 1 - buy, dp),
                             solve(prices, index + 1, buy, dp));
        }
        
        return dp[index][buy] = profit;
    }
}
class Solution {
    public int minCost(String s, int[] neededTime) {
        int sum = neededTime[0], max = neededTime[0], ans = 0, n = s.length();
        for(int i = 1 ; i < n ; i++){
            sum = neededTime[i - 1];
            max = neededTime[i - 1];
            while(i < n && s.charAt(i) == s.charAt(i - 1)){
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
                i++;
            }
            ans += sum - max;
        }
        
        return ans;
    }
}
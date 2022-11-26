class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] job = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }
        
        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        
        Integer[] dp = new Integer[n];
        
        return solve(job, 0, dp);
    }
    
    public int solve(int[][] job, int index, Integer[] dp){
        if(index >= job.length)
            return 0;
        
        if(dp[index] != null)
            return dp[index];
        
        int next = findNext(job, job[index][1], index);
        
       
        int include = job[index][2] + (next == -1 ? 0 : solve(job, next, dp));
        int exclude = solve(job, index + 1, dp);
        
        dp[index] = Math.max(include, exclude);
        
        return dp[index];
        
        
    }
    
    public int findNext(int[][] job, int endTime, int index){
        int low = index + 1, high = job.length - 1;
        int mid = 0 ;
        
        
        while(low <= high){
            mid = low + (high - low)/2 ;
            if(job[mid][0] >= endTime){
                if(job[mid - 1][0] >= endTime)
                    high = mid - 1;
                else
                    return mid;
            }
            else
                low = mid + 1;
        }
        
        return -1;
    }
}
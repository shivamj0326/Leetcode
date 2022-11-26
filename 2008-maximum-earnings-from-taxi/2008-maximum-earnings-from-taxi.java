class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        int[][] job = new int[rides.length][3];
        
        for(int i = 0 ; i < rides.length ; i++){
            job[i][0] = rides[i][0];
            job[i][1] = rides[i][1];
            job[i][2] = rides[i][1] - rides[i][0] + rides[i][2];
        }
        
        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        
        Long[] dp = new Long[job.length];
        
        return solve(job, 0, dp, n);
    }
    
    public long solve(int[][] job, int index, Long[] dp, int n){
        if(index > job.length - 1)
            return 0;
        
        if(dp[index] != null)
            return dp[index];
        
        int next = findNext(job, job[index][1], index);
        
       
        long include = job[index][2] + (next == -1 ? 0 : solve(job, next, dp, n));
        long exclude = solve(job, index + 1, dp, n);
        
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
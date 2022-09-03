class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
       for(int i = 1 ; i <= 9 ; i++){
           dfs(n - 1, k, res, i);
       }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    public void dfs(int n, int k, List<Integer> res, int num){
        if(n == 0){
            res.add(num);
            return;
        }
        else{
            int tail = num % 10 ;
            if(tail + k <= 9){
                dfs(n - 1, k, res, num*10 + tail + k);
            }
            if(k != 0 && tail >= k){
                dfs(n - 1, k, res, num*10 + tail - k);
            }
        }
            
        
    }
}
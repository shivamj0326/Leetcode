class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        
        int left = 0 , right = n - 1, sum = 0, score = 0 ;
        
        while(left <= right){
            if(power >= tokens[left]){
                score++;
                power -= tokens[left++];
            }
            else if(score >=1 && right - left > 1){
                power += tokens[right--];
                score--;
            }
            else
                break;
        }
        
        return score;
        
    }
}
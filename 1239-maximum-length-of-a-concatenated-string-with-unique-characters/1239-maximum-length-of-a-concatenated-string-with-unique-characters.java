class Solution {
    public int maxLength(List<String> arr) {
        
        int max = 0 ;   
        max = Math.max(max, solve(arr, 0, new int[26], 0));      
        return max;
    }
    
    public int solve(List<String> arr, int index, int[] count, int len){
        if(index == arr.size()){
            return len;
        }
        
        boolean canPick = canpick(count, arr.get(index));
        
        int pick = 0, notpick = 0;
        
        
        if(canPick){
            
            String current = arr.get(index);
            for(char c : current.toCharArray()){
                count[c - 'a']++;
                len++;
            }
            pick = solve(arr, index + 1, count, len);
            for(char c : current.toCharArray()){
                count[c - 'a']--;
                len--;
            }
            
            notpick = solve(arr, index + 1, count, len);
        }
        else{
            notpick = solve(arr, index + 1, count, len);
        }
        
        return Math.max(pick, notpick);        
    }
                           
    public boolean canpick(int[] count, String s){
        
        int a = 0 ;  
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1)
                return false;
            if((a & (1 << (c - 'a'))) == 0)
                a = a | (1 << (c - 'a'));
            else
                return false;
        }
        
        return true;
    }         
}
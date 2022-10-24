class Solution {
    public int maxLength(List<String> arr) {
        
        int max = 0 ;
        
        max = Math.max(max, solve(arr, 0, new int[26]));
        
        return max;

    }
    
    public int solve(List<String> arr, int index, int[] count){
        if(index == arr.size()){
            int ans = 0 ;
            
            for(int i = 0 ; i < count.length ; i++){
                ans += count[i];
            }
            
            return ans;
        }
        
        boolean canPick = canpick(count, arr.get(index));
        
        boolean isUnique = isUnique(arr.get(index));
        
        int pick = 0, notpick = 0;
        
        
        if(canPick && isUnique){
            String current = arr.get(index);
            for(char c : current.toCharArray()){
                count[c - 'a']++;
            }
            pick = solve(arr, index + 1, count);
            for(char c : current.toCharArray()){
                count[c - 'a']--;
            }
            
            notpick = solve(arr, index + 1, count);
        }
        else{
            notpick = solve(arr, index + 1, count);
        }
        
        return Math.max(pick, notpick);        
    }
                           
    public boolean canpick(int[] count, String s){
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1)
                return false;
        }
        
        return true;
    }
    
    public boolean isUnique(String s){
        
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c))
                return false;
            else
                set.add(c);
        }
        
        return true;
    }
                           
                           
}
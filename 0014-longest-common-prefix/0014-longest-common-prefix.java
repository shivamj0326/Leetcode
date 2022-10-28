class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        
        for(int i = 1 ; i < strs.length; i++){
            common = commonPrefix(common, strs[i]);
        }
        
        return common;
    }
    
    public String commonPrefix(String a, String b){
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Math.min(a.length(), b.length()); i++){
            if(a.charAt(i) != b.charAt(i))
                break;
            sb.append(a.charAt(i));
        }
        
        return sb.toString();
    }
}
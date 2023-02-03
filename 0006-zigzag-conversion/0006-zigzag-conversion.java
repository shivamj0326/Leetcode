class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1)
            return s;
        StringBuilder[] r = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows; i++){
            r[i] = new StringBuilder();
        }
        int end = 0 , top = 0 , direction = 0 ;
        for(int i = 0, index = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(direction == 0){
                end = index >= (numRows - 1) ? 1 : 0 ;
                if(end == 1){
                    direction = 1;
                }
                r[index].append(ch);
                index = end == 1 ? (index - 1) : (index + 1);
            }
            else{
                top = index <= 0 ? 1 : 0;
                if(top == 1){
                    direction = 0 ;
                }
                r[index].append(ch);
                index = top == 1 ? (index + 1) : (index - 1);
                
            }
            
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++){
            res.append(r[i].toString());
            
        }
        return res.toString();
    }
}
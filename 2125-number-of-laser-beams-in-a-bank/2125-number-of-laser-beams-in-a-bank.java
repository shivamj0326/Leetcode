class Solution {
    public int numberOfBeams(String[] bank) {
        int pOnes=0; int res=0;
        for(String s: bank){
            int count=(int)s.chars().filter(ch->ch=='1').count();
            res+=(count*pOnes);
            if(count>0)
                pOnes=count;
        }
        return res;
    }
}
class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0 ;
        
        int n = nums.length;
        
        List<Integer> oddNum = new ArrayList<>();
        
        List<Integer> evenNum = new ArrayList<>();
        
        List<Integer> oddTar = new ArrayList<>();
        
        List<Integer> evenTar = new ArrayList<>();
        
        
        
        for(int i = 0 ; i < n; i++){
            if(nums[i] % 2 == 0)
                evenNum.add(nums[i]);
            else
                oddNum.add(nums[i]);
            
            if(target[i] % 2 == 0)
                evenTar.add(target[i]);
            else
                oddTar.add(target[i]);
        }
        
        Collections.sort(oddNum);
        Collections.sort(evenNum);
        Collections.sort(oddTar);
        Collections.sort(evenTar);
        
        
        for(int i = 0 ; i < oddTar.size() ; i++){
            int diff = Math.abs(oddTar.get(i) - oddNum.get(i));
            ans += diff/2 ;
            
            
        }
        
        for(int i = 0 ; i < evenTar.size() ; i++){
            
           int diff = Math.abs(evenTar.get(i) - evenNum.get(i));
           
            ans += diff/2 ;
        }
        
        return ans/2;
    }
}
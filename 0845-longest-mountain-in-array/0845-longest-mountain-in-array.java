class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> de = new HashMap<>();
        
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        b[n - 1] = 1;
        
        in.put(arr[0], 1);
        de.put(arr[n - 1], 1);
        
        for(int i = 1 ; i < n ; i++){
            int l = 0;
            if(arr[i] > arr[i - 1]){
                l = in.getOrDefault(arr[i - 1], 0);
            }
            a[i] = l + 1;
            in.put(arr[i], a[i]);
        }
        
        for(int i = n - 2 ; i >= 0 ; i--){
            int l = 0;
            if(arr[i] > arr[i + 1]){
                l = de.getOrDefault(arr[i + 1], 0);
            }
            b[i] = l + 1;
            de.put(arr[i], b[i]);
        }
        
        int max = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            if(a[i] > 1 && b[i] > 1)
            max = Math.max(max, a[i] + b[i] - 1);
        }
        
        return max < 3 ? 0 : max;
    }
}
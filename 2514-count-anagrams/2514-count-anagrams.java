class Solution {
    private static final int MOD = 1000000007;
    public int countAnagrams(String s) {
        String[] strs = s.split(" ");
        long result = 1;
        int maxLen = 0;
        for (String str : strs) {            
            maxLen = Math.max(maxLen, str.length());
        }
        int[] factorial = getFactorial(maxLen);
        int[] invFactorial = getInverseFactorial(maxLen, factorial);
        int[] count = new int[26];
        int len = 0;
        long numOfPermutations = 0;
        for (String str : strs) {
            Arrays.fill(count, 0);
            len = str.length();
            for (int i = 0; i < len; i++) {
                count[str.charAt(i) - 'a']++;
            }
            numOfPermutations = factorial[len];
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    numOfPermutations = (numOfPermutations * invFactorial[count[i]]) % MOD;
                }
            }
            result = (result * numOfPermutations) % MOD;
        }
        return (int) result;
    }
    private int[] getFactorial(int num) {
        int[] factorial = new int[num + 1];
        factorial[0] = 1;
        for (int i = 1; i <= num; i++) {
            factorial[i] = (int) ((1L * factorial[i - 1] * i) % MOD);
        }
        return factorial;
    }
    private int[] getInverseFactorial(int num, int[] factorial) {
        int[] invFactorial = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            invFactorial[i] = (int) powMod(factorial[i], MOD - 2) % MOD;
        }
        return invFactorial;
    }
    private long powMod(long num, int pow) {
        long result = 1;
        while (pow >= 1) {
            if (pow % 2 == 1) {
                result = (result * num) % MOD;
            }
            pow /= 2;
            num = (num * num) % MOD;
        }
        return result;
    }
}
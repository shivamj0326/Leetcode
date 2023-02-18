class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> substrFreqMap = new HashMap<>();
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int maxCount = 0;
        for (int windowStart = 0, windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            charFreqMap.put(endChar, charFreqMap.getOrDefault(endChar, 0) + 1);
            while (charFreqMap.size() > maxLetters || (windowEnd - windowStart + 1) > minSize) {
                char startChar = s.charAt(windowStart++);
                charFreqMap.put(startChar, charFreqMap.get(startChar) - 1);
                if (charFreqMap.get(startChar) == 0) {
                    charFreqMap.remove(startChar);
                }
            }
            if ((windowEnd - windowStart + 1) == minSize) {
                String substr = s.substring(windowStart, windowEnd + 1);
                int count = substrFreqMap.getOrDefault(substr, 0) + 1;
                substrFreqMap.put(substr, count);
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
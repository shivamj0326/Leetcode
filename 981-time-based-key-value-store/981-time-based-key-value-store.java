class TimeMap {
    
    Map<String, String> keyMap = new HashMap<>();
    
    Map<String, TreeSet<Integer>> timeMap = new HashMap<>();

    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.put(key + "#" + timestamp, value);
        if(timeMap.containsKey(key)){
            TreeSet<Integer> timeset = timeMap.get(key);
            timeset.add(timestamp);
            timeMap.put(key, timeset);
        }
        else{
            TreeSet<Integer> timeset = new TreeSet<>();
            timeset.add(timestamp);
            timeMap.put(key, timeset);
        }
            
    }
    
    public String get(String key, int timestamp) {
        if(keyMap.containsKey(key + "#" + timestamp))
            return keyMap.get(key + "#" + timestamp);
        else{
            TreeSet<Integer> set = timeMap.get(key);
            if(set == null)
                return "";
            Integer time = set.floor(timestamp);
            if(time == null)
                return "";
            return keyMap.get(key + "#" + time);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
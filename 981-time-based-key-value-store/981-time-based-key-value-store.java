class TimeMap {
    
    private Map<String, TreeMap<Integer, String>> keyMap ;
    
    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       TreeMap<Integer, String> timeMap = keyMap.get(key);
        if(timeMap == null)
            timeMap = new TreeMap<Integer, String>();
        timeMap.put(timestamp, value);
        keyMap.put(key, timeMap);
            
    }
    
    public String get(String key, int timestamp) {
        if(!keyMap.containsKey(key))
            return "";
        TreeMap<Integer, String> timeMap = keyMap.get(key);
        Integer time = timeMap.floorKey(timestamp);
        if(time == null)
            return "";
        return timeMap.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
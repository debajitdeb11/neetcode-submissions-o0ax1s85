public class TimeMap {
    class CacheValue implements Comparable<CacheValue> {
        public String value;
        public int timestamp;
        
        public CacheValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
        
        @Override
        public int compareTo(CacheValue o) {
            return o.timestamp - this.timestamp;
        }
    }
    
    private final Map<String, List<CacheValue>> cache;

    public TimeMap() {
        this.cache = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.cache.putIfAbsent(key, new ArrayList<>());
        
        this.cache.get(key).add(new CacheValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!this.cache.containsKey(key)) {
            return "";
        }
        
        List<CacheValue> values = this.cache.get(key);

        int l = 0;
        int h = values.size() - 1;
        
        String res = "";
        
        while (l <= h) {
            int m = l + (h - l) / 2;
            
            if (values.get(m).timestamp <= timestamp) {
                res = values.get(m).value;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return res;
    }
}

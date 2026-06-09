

class TimeMap {
    // Corrected type name: 'String' instead of 'Strng'
    private Map<String, List<Pair<Integer, String>>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Use computeIfAbsent correctly: initialize with a new ArrayList
        mp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // Use getOrDefault to avoid NullPointerException
        List<Pair<Integer, String>> temp = mp.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int h = temp.size() - 1;
        String res = "";
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (temp.get(mid).key <= timestamp) {
                res = temp.get(mid).value;
                l = mid + 1; // Look for a later timestamp
            } else {
                h = mid - 1;
            }
        }
        return res;
    }

    // Corrected Pair class: Added types K and V to the class definition
    private static class Pair<K, V> {
        private final K key;
        private final V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
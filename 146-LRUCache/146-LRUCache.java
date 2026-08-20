// Last updated: 8/20/2026, 7:18:47 PM
1class LRUCache {
2
3    private final Map<Integer, Integer> cache;
4
5    public LRUCache(int capacity) {
6        cache = new LinkedHashMap<Integer, Integer>(
7                (int) (capacity / 0.75),
8                0.75f,
9                true) {
10            @Override
11            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
12                return size() > capacity;
13            }
14        };
15    }
16
17    public int get(int key) {
18        var value = cache.get(key);
19        
20        return value == null ? -1 : value;
21    }
22
23    public void put(int key, int value) {
24        cache.put(key, value);
25    }
26}
27
28/**
29 * Your LRUCache object will be instantiated and called as such:
30 * LRUCache obj = new LRUCache(capacity);
31 * int param_1 = obj.get(key);
32 * obj.put(key,value);
33 */
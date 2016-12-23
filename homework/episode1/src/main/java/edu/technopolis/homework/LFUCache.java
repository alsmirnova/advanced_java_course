package adv_java.LFU_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алена on 23.12.2016.
 */

public class LFUCache {

    private static int initialCapacity = 10;

    private static HashMap<Integer, EntryCache> cacheMap = new HashMap<Integer, EntryCache>();
/* LinkedHashMap is used because it has features of both HashMap and LinkedList.
 * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
 * */

    public LFUCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void addCacheEntry(int key, String data) {
        if (!isFull()) {
            EntryCache temp = new EntryCache();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            EntryCache temp = new EntryCache();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, EntryCache> entry : cacheMap.entrySet()) {
            if (minFreq > entry.getValue().getFrequency()) {
                key = entry.getKey();
                minFreq = entry.getValue().getFrequency();
            }
        }

        return key;
    }

    public String getCacheEntry(int key) {
        if (cacheMap.containsKey(key))  // cache hit
        {
            EntryCache temp = cacheMap.get(key);
            temp.getFrequency();
            cacheMap.put(key, temp);
            return temp.getData();
        }
        return null; // cache miss
    }

    public static boolean isFull() {
        if (cacheMap.size() == initialCapacity)
            return true;

        return false;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(4);
        lfu.addCacheEntry(1, "a");
        lfu.addCacheEntry(2, "b");
        lfu.addCacheEntry(3, "c");
        lfu.addCacheEntry(4, "d");

        lfu.getCacheEntry(4);
        lfu.getCacheEntry(2);
        lfu.getCacheEntry(1);
        lfu.addCacheEntry(5,"v");
        System.out.println(lfu.getCacheEntry(1)); //null
        System.out.println(lfu.getCacheEntry(2)); //b


    }
}

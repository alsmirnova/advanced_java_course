package ru.mail.polis.sort.valid;

import adv_java.lfu_cache.LFUCache;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class TesterLFU {

    private LFUCache c;

    public TesterLFU() {
        this.c = new LFUCache(2);
    }

    @Test
    public void testCacheStartsEmpty() throws IOException, AssertionError {
        c=new LFUCache(2);
        assertEquals(c.getCacheEntry(1), "1");
    }

    @Test
    public void testSetBelowCapacity() throws IOException, AssertionError {
        c=new LFUCache(2);
        c.addCacheEntry(1, "1");
        assertEquals(c.getCacheEntry(1), "1");
        //assertEquals(c.getCacheEntry(2), "1");
        c.addCacheEntry(2, "4");
        assertEquals(c.getCacheEntry(1), "1");
        assertEquals(c.getCacheEntry(2), "4");
    }

    @Test
    public void testCapacityReachedOldestRemoved() throws IOException, AssertionError {
        c=new LFUCache(2);
        c.addCacheEntry(1, "1");
        c.addCacheEntry(2, "4");
        c.addCacheEntry(3, "9");
        assertEquals(c.getCacheEntry(1), "1");
        assertEquals(c.getCacheEntry(2), "4");
        assertEquals(c.getCacheEntry(3), "9");
    }

    @Test
    public void testGetRenewsEntry() {
        c=new LFUCache(2);
        c.addCacheEntry(1, "1");
        c.addCacheEntry(2, "4");
        assertEquals(c.getCacheEntry(1), "1");
        c.addCacheEntry(3, "9");
        assertEquals(c.getCacheEntry(1), "1");
        assertEquals(c.getCacheEntry(2), "1");
        assertEquals(c.getCacheEntry(3), "9");
    }


}
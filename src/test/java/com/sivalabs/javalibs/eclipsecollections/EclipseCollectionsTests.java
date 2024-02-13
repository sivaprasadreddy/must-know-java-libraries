package com.sivalabs.javalibs.eclipsecollections;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.factory.BiMaps;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.impl.factory.Multimaps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EclipseCollectionsTests {

    @Test
    void testEC() {
        MutableList<String> mutableListOf =
                Lists.mutable.of("One", "One", "Two", "Three");
        assertEquals(3, mutableListOf.distinct().size());

        MutableBag<String> mutableBag =
                Bags.mutable.with("One", "One", "Two", "Three");
        assertEquals(4, mutableBag.size());
        assertEquals(3, mutableBag.sizeDistinct());

        MutableMultimap<String, String> multimapWithList =
                Multimaps.mutable.list.with("key1", "value1-1", "key1", "value1-2", "key2","value2-1");
        assertEquals(2, multimapWithList.get("key1").size());

        MutableBiMap<String, String> mutableBiMap =
                BiMaps.mutable.with("key1", "value1", "key2", "value2", "key3", "value3");
        assertEquals("value1", mutableBiMap.get("key1"));
        assertEquals("key1", mutableBiMap.inverse().get("value1"));
    }
}

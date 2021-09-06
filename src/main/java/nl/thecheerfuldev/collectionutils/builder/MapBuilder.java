package nl.thecheerfuldev.collectionutils.builder;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {

    private final Map<K, V> map;

    public MapBuilder() {
        map = new HashMap<>();
    }

    public MapBuilder(Map<? extends K, ? extends V> input) {
        this();
        map.putAll(input);
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return Map.copyOf(map);
    }

}

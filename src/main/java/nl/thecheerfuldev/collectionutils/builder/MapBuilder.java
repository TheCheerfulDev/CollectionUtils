package nl.thecheerfuldev.collectionutils.builder;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {

    private final Map<K, V> map;

    public MapBuilder() {
        map = new HashMap<>();
    }

    public MapBuilder(K key, V value) {
        this();
        map.put(key, value);
    }

    public MapBuilder(Map<? extends K, ? extends V> input) {
        this();
        map.putAll(input);
    }

    public static <K, V> MapBuilder<K, V> builder(K key, V value) {
        return new MapBuilder<>(key, value);
    }

    public static <K, V> MapBuilder<K, V> builder(Map<? extends K, ? extends V> input) {
        return new MapBuilder<>(input);
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return Map.copyOf(map);
    }
}

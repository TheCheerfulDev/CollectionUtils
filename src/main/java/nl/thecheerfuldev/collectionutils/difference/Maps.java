package nl.thecheerfuldev.collectionutils.difference;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Maps {

    private Maps() {
    }

    public static <K, V> Map<K, DiffResult<K, V>> difference(Map<K, V> leftMap, Map<K, V> rightMap) {
        return leftMap.entrySet()
                .stream()
                .filter(leftEntry -> rightMap.containsKey(leftEntry.getKey()))
                .filter(leftEntry -> !rightMap.get(leftEntry.getKey()).equals(leftEntry.getValue()))
                .map(leftEntry -> new DiffResult<>(leftEntry.getKey(), leftEntry.getValue(), rightMap.get(leftEntry.getKey())))
                .collect(Collectors.toUnmodifiableMap(DiffResult::key, Function.identity()));
    }

    public static <K, V> Map<K, Set<V>> union(Map<K, V> leftMap, Map<K, V> rightMap) {
        Map<K, Set<V>> result = new HashMap<>();

        leftMap.forEach((k, v) -> {
            result.putIfAbsent(k, new HashSet<>());
            result.get(k).add(v);
        });

        rightMap.forEach((k, v) -> {
            result.putIfAbsent(k, new HashSet<>());
            result.get(k).add(v);
        });

        result.forEach((k, v) -> result.put(k, Set.copyOf(result.get(k))));

        return Map.copyOf(result);
    }

    public record DiffResult<K, V>(K key, V leftValue, V rightValue) {
    }

}

package nl.thecheerfuldev.collectionutils.difference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Maps {

    public static <K, V> Map<K, DiffResult<K, V>> difference(Map<K, V> leftMap, Map<K, V> rightMap) {
        return leftMap.entrySet()
                .stream()
                .filter(leftEntry -> rightMap.containsKey(leftEntry.getKey()))
                .filter(leftEntry -> !rightMap.get(leftEntry.getKey()).equals(leftEntry.getValue()))
                .map(leftEntry -> new DiffResult<>(leftEntry.getKey(), leftEntry.getValue(), rightMap.get(leftEntry.getKey())))
                .collect(Collectors.toUnmodifiableMap(DiffResult::getKey, Function.identity()));
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

        result.forEach((k, v) -> {
            result.get(k);
            result.put(k, Set.copyOf(result.get(k)));
        });

        return Map.copyOf(result);
    }

    public static class DiffResult<K, V> {
        private final K key;
        private final V leftValue;
        private final V rightValue;

        public DiffResult(K key, V leftValue, V rightValue) {
            this.key = key;
            this.leftValue = leftValue;
            this.rightValue = rightValue;
        }

        public K getKey() {
            return key;
        }

        public V getLeftValue() {
            return leftValue;
        }

        public V getRightValue() {
            return rightValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DiffResult<?, ?> that = (DiffResult<?, ?>) o;

            if (!key.equals(that.key)) return false;
            if (!leftValue.equals(that.leftValue)) return false;
            return rightValue.equals(that.rightValue);
        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + leftValue.hashCode();
            result = 31 * result + rightValue.hashCode();
            return result;
        }
    }


}


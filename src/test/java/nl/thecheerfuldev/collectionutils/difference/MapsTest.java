package nl.thecheerfuldev.collectionutils.difference;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MapsTest {

    @Test
    void difference_with_same_map_returns_empty_map() {
        Map<String, Integer> completeMap = Map.of("A", 1, "B", 2, "C", 3);

        assertThat(Maps.difference(completeMap, completeMap)).isEmpty();
    }

    @Test
    void difference_with_actual_difference_returns_different_map() {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3, "X", 7);
        Map<String, Integer> map2 = Map.of("A", 1, "B", 2, "C", 5, "Z", 9);

        Map<String, Maps.DiffResult<String, Integer>> expected = Map.of("C", new Maps.DiffResult<>("C", 3, 5));

        assertThat(Maps.difference(map1, map2)).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    void union_with_same_map_returns_map_with_same_results() {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);

        Map<String, Set<Integer>> expected = Map.of("A", Set.of(1), "B", Set.of(2), "C", Set.of(3));

        assertThat(Maps.union(map1, map1)).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    void union_with_map_with_different_values_for_key_returns_map_with_multiple_results_for_key() {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> map2 = Map.of("A", 1, "B", 2, "C", 4);

        Map<String, Set<Integer>> expected = Map.of("A", Set.of(1), "B", Set.of(2), "C", Set.of(3, 4));

        assertThat(Maps.union(map1, map2)).containsExactlyInAnyOrderEntriesOf(expected);
    }
}
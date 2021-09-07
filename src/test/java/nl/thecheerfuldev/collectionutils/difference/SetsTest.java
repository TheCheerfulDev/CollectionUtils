package nl.thecheerfuldev.collectionutils.difference;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetsTest {

    @Test
    void intersection_with_same_set_returns_same_set() {
        Set<String> completeSet = Set.of("A", "B", "C");

        assertThat(Sets.intersection(completeSet, completeSet)).containsExactlyInAnyOrderElementsOf(completeSet);
    }

    @Test
    void intersection_with_no_intersecting_sets_returns_empty_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("X", "Y", "Z");

        assertThat(Sets.intersection(set1, set2)).isEmpty();
    }

    @Test
    void intersection_with_intersecting_sets_returns_intersecting_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("C", "D", "E");

        Set<String> expected = Set.of("C");

        assertThat(Sets.intersection(set1, set2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void symmetric_with_same_set_returns_empty_set() {
        Set<String> completeSet = Set.of("A", "B", "C");

        assertThat(Sets.symmetric(completeSet, completeSet)).isEmpty();
    }

    @Test
    void symmetric_with_completely_different_sets_returns_complete_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("X", "Y", "Z");

        Set<String> expected = Set.of("A", "B", "C", "X", "Y", "Z");

        assertThat(Sets.symmetric(set1, set2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void symmetric_with_overlapping_sets_returns_symmetric_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("C", "D", "E");

        Set<String> expected = Set.of("A", "B", "D", "E");

        assertThat(Sets.symmetric(set1, set2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void difference_with_same_sets_returns_empty_set() {
        Set<String> completeSet = Set.of("A", "B", "C");

        assertThat(Sets.difference(completeSet, completeSet)).isEmpty();
    }

    @Test
    void difference_with_overlapping_sets_returns_difference_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("C", "D", "E");

        Set<String> expected = Set.of("A", "B");

        assertThat(Sets.difference(set1, set2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void difference_with_completely_different_sets_returns_first_set() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("X", "Y", "Z");

        assertThat(Sets.difference(set1, set2)).containsExactlyInAnyOrderElementsOf(set1);
    }

    @Test
    void union_with_same_set_returns_same_set() {
        Set<String> completeSet = Set.of("A", "B", "C");

        assertThat(Sets.union(completeSet, completeSet)).containsExactlyInAnyOrderElementsOf(completeSet);
    }

    @Test
    void union_with_completely_different_lists_returns_complete_list() {
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("X", "Y", "Z");

        Set<String> expected = Set.of("A", "B", "C", "X", "Y", "Z");

        assertThat(Sets.union(set1, set2)).containsExactlyInAnyOrderElementsOf(expected);
    }
}

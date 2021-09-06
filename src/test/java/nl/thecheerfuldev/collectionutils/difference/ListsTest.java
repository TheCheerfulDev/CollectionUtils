package nl.thecheerfuldev.collectionutils.difference;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListsTest {

    @Test
    void intersection_with_same_list_returns_same_list() {
        List<String> completeList = List.of("A", "B", "C");

        assertThat(Lists.intersection(completeList, completeList)).containsExactlyInAnyOrderElementsOf(completeList);
    }

    @Test
    void intersection_with_no_intersecting_lists_returns_empty_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("X", "Y", "Z");

        assertThat(Lists.intersection(list1, list2)).isEmpty();
    }

    @Test
    void intersection_with_intersecting_lists_returns_intersecting_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("C", "D", "E");

        List<String> expected = List.of("C");

        assertThat(Lists.intersection(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void intersection_with_intersecting_lists_with_duplicates_returns_intersecting_list() {
        List<String> list1 = List.of("A", "A", "B", "C");
        List<String> list2 = List.of("C", "D", "E");

        List<String> expected = List.of("C");

        assertThat(Lists.intersection(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void symmetric_with_same_set_returns_empty_list() {
        List<String> completeSet = List.of("A", "B", "C");

        assertThat(Lists.symmetric(completeSet, completeSet)).isEmpty();
    }

    @Test
    void symmetric_with_completely_different_lists_returns_complete_list() {
        List<String> list1 = List.of("A", "A", "B", "C");
        List<String> list2 = List.of("X", "Y", "Z");

        List<String> expected = List.of("A", "A", "B", "C", "X", "Y", "Z");

        assertThat(Lists.symmetric(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void symmetric_with_overlapping_lists_returns_symmetric_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("C", "D", "E");

        List<String> expected = List.of("A", "B", "D", "E");

        assertThat(Lists.symmetric(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void symmetric_with_overlapping_lists_with_duplicates_returns_symmetric_list() {
        List<String> list1 = List.of("A", "B", "C", "C");
        List<String> list2 = List.of("C", "D", "E", "E");

        List<String> expected = List.of("A", "B", "D", "E", "E");

        assertThat(Lists.symmetric(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void difference_with_same_lists_returns_empty_list() {
        List<String> completeList = List.of("A", "B", "C");

        assertThat(Lists.difference(completeList, completeList)).isEmpty();
    }

    @Test
    void difference_with_overlapping_lists_returns_difference_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("C", "D", "E");

        List<String> expected = List.of("A", "B");

        assertThat(Lists.difference(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void difference_with_overlapping_lists_with_duplicates_returns_difference_list() {
        List<String> list1 = List.of("A", "B", "B", "C");
        List<String> list2 = List.of("C", "D", "E");

        List<String> expected = List.of("A", "B", "B");

        assertThat(Lists.difference(list1, list2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void difference_with_completely_different_Lists_returns_first_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("X", "Y", "Z");

        assertThat(Lists.difference(list1, list2)).containsExactlyInAnyOrderElementsOf(list1);
    }
}
